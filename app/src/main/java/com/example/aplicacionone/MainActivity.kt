package com.example.aplicacionone

import android.os.Bundle
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.example.aplicacionone.ui.theme.AplicacionOneTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp() }
    }
}

@Composable
fun MyApp() {
    // Controla el estado de los temas de la aplicación (oscuro y tema amigo)
    var isDarkTheme by remember { mutableStateOf(false) }
    var isKebabTheme by remember { mutableStateOf(false) }

    // Aplica el tema de la aplicación usando los valores actuales de `isDarkTheme` e `isKebabTheme`
    AplicacionOneTheme(darkTheme = isDarkTheme, kebabTheme = isKebabTheme) {
        MenuCompletoApp(
            isDarkTheme = isDarkTheme,
            isKebabTheme = isKebabTheme,
            onThemeChange = { isDarkTheme = it },
            onKebabThemeChange = { isKebabTheme = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuCompletoApp(
    isDarkTheme: Boolean,
    isKebabTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onKebabThemeChange: (Boolean) -> Unit
) {
    // Variables de estado para controlar elementos seleccionados, estado de temas, y diálogos
    val kebabs = remember { mutableStateListOf<String>() }
    var bebidaSeleccionada by remember { mutableStateOf("") }
    var metodoPago by remember { mutableStateOf("Efectivo") }
    var incluirLechuga by remember { mutableStateOf(true) }
    var incluirTomate by remember { mutableStateOf(true) }
    var incluirCebolla by remember { mutableStateOf(true) }
    var patataSeleccionada by remember { mutableStateOf("") }
    var mostrarResumen by remember { mutableStateOf(false) }
    var horaEntrega by remember { mutableStateOf("") }
    var pedidoConfirmado by remember { mutableStateOf(false) }
    var mostrandoProgreso by remember { mutableStateOf(false) }
    var mostrarImagen by remember { mutableStateOf(false) }

    // Opciones para distintos elementos de la selección
    val carneOpciones = listOf("Pollo", "Mixto", "Ternera")
    val bebidaOpciones = listOf("Nestea", "Agua", "Pepsi", "Coca Cola Zero", "Coca Cola Normal", "Fanta de Naranja", "Fanta de Limón")
    val metodoPagoOpciones = listOf("Efectivo", "Tarjeta")
    val patataOpciones = listOf("Con salsa", "Sin salsa")

    val buttonShape = if (isKebabTheme) RoundedCornerShape(3.dp) else RoundedCornerShape(18.dp)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Menú Completo") })
        }
    ) { paddingInterior ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterior)
                .padding(6.dp)
        ) {
            // Selección de carne para el kebab
            Text("Selecciona un tipo de Carne:")
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                carneOpciones.forEach { kebab ->
                    Button(
                        onClick = { kebabs.add(kebab); mostrarResumen = false },
                        shape = buttonShape
                    ) {
                        Text(kebab)
                    }
                }
            }

            if (kebabs.isNotEmpty()) {
                Text("Carne seleccionada: ${kebabs.last()}")
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Selección de verduras
            Text("Verduras:")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = incluirLechuga, onCheckedChange = { incluirLechuga = it })
                Text("Lechuga")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = incluirTomate, onCheckedChange = { incluirTomate = it })
                Text("Tomate")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = incluirCebolla, onCheckedChange = { incluirCebolla = it })
                Text("Cebolla")
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Selección de bebida
            Text("Selecciona una bebida:")
            var bebidaDialogVisible by remember { mutableStateOf(false) }
            TextField(
                value = bebidaSeleccionada,
                onValueChange = {},
                label = { Text("Bebida") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { bebidaDialogVisible = true }) {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Desplegar")
                    }
                }
            )

            if (bebidaDialogVisible) {
                AlertDialog(
                    onDismissRequest = { bebidaDialogVisible = false },
                    title = { Text("Selecciona una bebida") },
                    text = {
                        LazyColumn {
                            items(bebidaOpciones) { bebida ->
                                TextButton(onClick = {
                                    bebidaSeleccionada = bebida
                                    bebidaDialogVisible = false
                                    mostrarResumen = false
                                }) {
                                    Text(bebida)
                                }
                            }
                        }
                    },
                    confirmButton = { Button(onClick = { bebidaDialogVisible = false }) { Text("Cerrar") } }
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Selección de tipo de patatas
            Text("Selecciona tipo de Patatas:")
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                patataOpciones.forEach { patata ->
                    Button(
                        onClick = { patataSeleccionada = patata; mostrarResumen = false },
                        shape = buttonShape
                    ) {
                        Text(patata)
                    }
                }
            }

            if (patataSeleccionada.isNotEmpty()) {
                Text("Patatas seleccionadas: $patataSeleccionada")
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Selección de método de pago
            Text("Método de pago:")
            metodoPagoOpciones.forEach { metodo ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = metodoPago == metodo, onClick = { metodoPago = metodo })
                    Text(text = metodo)
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Botón para mostrar el resumen del pedido
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = { mostrarResumen = true },
                    shape = buttonShape
                ) {
                    Text("Siguiente")
                }
            }

            // Resumen del pedido en diálogo
            if (mostrarResumen) {
                ResumenPedidoDialog(
                    kebabs = kebabs,
                    bebidaSeleccionada = bebidaSeleccionada,
                    patataSeleccionada = patataSeleccionada,
                    metodoPago = metodoPago,
                    incluirLechuga = incluirLechuga,
                    incluirTomate = incluirTomate,
                    incluirCebolla = incluirCebolla,
                    onConfirm = {
                        mostrandoProgreso = true
                        mostrarResumen = false
                    },
                    onDismiss = { mostrarResumen = false },
                    onHoraChange = { horaEntrega = it }
                )
            }


            Spacer(modifier = Modifier.height(30.dp))

            // Indicador de progreso mientras se confirma el pedido
            if (mostrandoProgreso) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Text("Confirmando pedido...", modifier = Modifier.align(Alignment.CenterHorizontally))

                LaunchedEffect(Unit) {
                    delay(3000)
                    mostrandoProgreso = false
                    pedidoConfirmado = true
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Mensaje de confirmación del pedido
            if (pedidoConfirmado) {
                Text(
                    "Pedido confirmado",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Botón para mostrar la imagen de la carta
            Button(
                shape = buttonShape,
                        onClick = { mostrarImagen = true }) {
                Text("Carta")
            }

            if (mostrarImagen) {
                Dialog(onDismissRequest = { mostrarImagen = false }) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagen),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Opciones para cambiar temas
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text("Modo Oscuro:")
                Switch(checked = isDarkTheme, onCheckedChange = onThemeChange)
                Text("Modo Amigo:")
                Switch(checked = isKebabTheme, onCheckedChange = onKebabThemeChange)
            }
        }
    }
}

@Composable
fun ResumenPedidoDialog(
    kebabs: List<String>,
    bebidaSeleccionada: String,
    patataSeleccionada: String,
    metodoPago: String,
    incluirLechuga: Boolean,
    incluirTomate: Boolean,
    incluirCebolla: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    onHoraChange: (String) -> Unit
) {
    // Resumen de pedido mostrado en diálogo con selección de hora de entrega
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Resumen del pedido") },
        text = {
            Column {
                Text("Carne seleccionada: ${kebabs.joinToString(", ")}")
                Text("Bebida seleccionada: $bebidaSeleccionada")
                Text("Patatas: $patataSeleccionada")
                Text("Método de pago: $metodoPago")

                // Mostrar verduras seleccionadas
                Text("Verduras seleccionadas:")
                if (incluirLechuga) Text("- Lechuga")
                if (incluirTomate) Text("- Tomate")
                if (incluirCebolla) Text("- Cebolla")

                // Selector de hora de entrega
                AndroidView(factory = { context ->
                    TimePicker(context).apply {
                        setOnTimeChangedListener { _, hour, minute ->
                            onHoraChange("$hour:$minute")
                        }
                    }
                })
            }
        },
        confirmButton = { Button(onClick = onConfirm) { Text("Confirmar") } },
        dismissButton = { Button(onClick = onDismiss) { Text("Cancelar") } }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
