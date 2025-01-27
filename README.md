# Menú de Kebab - Aplicación Móvil

¡Bienvenido a la aplicación móvil del Menú de Kebab! Este proyecto te permite personalizar tus pedidos de kebab de una forma interactiva, implementando los principios de Material Design con una interfaz moderna y amigable.

## 🍖 Características principales

- **Selección de alimentos**:
  - Escoge el tipo de carne, bebida y patatas para tu pedido.
  - Opciones para agregar o quitar ingredientes como verduras.
- **Carrito de compras**:
  - Visualiza y edita los elementos seleccionados antes de confirmar tu pedido.
- **Resumen del pedido**:
  - Muestra un desglose detallado de los elementos seleccionados, incluyendo la hora estimada de entrega.
- **Interactividad dinámica**:
  - Cambios en la interfaz basados en las selecciones del usuario.
- **Diseño adaptable**:
  - Optimizado para dispositivos móviles, siguiendo los estándares de Material Design.

## 🎮 Modos de uso

### Personalización del pedido
- Selecciona la carne, bebida y tipo de patatas desde la pantalla principal.
- Usa checkboxes para incluir o excluir ingredientes adicionales.

### Visualización del carrito
- Consulta el contenido del carrito antes de confirmar.
- Modifica o elimina elementos fácilmente.

### Confirmación del pedido
- Una vez finalizado, muestra un mensaje de "Pedido confirmado" con los detalles principales.

## 📂 Estructura del proyecto

### Código principal
- **MainScreen.kt**: Pantalla principal donde se seleccionan los elementos del pedido.
- **CartScreen.kt**: Visualización y gestión del carrito.
- **ConfirmationScreen.kt**: Muestra el resumen final del pedido.

### Estilos
- **styleMain.css**: Estilos para la pantalla principal.
- **styleCart.css**: Estilos para la visualización del carrito.
- **styleConfirmation.css**: Estilos para la pantalla de confirmación.

### Recursos visuales
- Iconos y gráficos en la carpeta `images/`:
  - Iconos para ingredientes y tipos de kebab.
  - Imágenes de fondo personalizadas para cada pantalla.

## 💻 Requisitos

- **Java 11+**: Asegúrate de tener una versión compatible del JDK.
- **Android Studio**: Configurado con soporte para Kotlin y Material Design.
- **Archivos de recursos**: Verifica que la carpeta `images/` esté correctamente ubicada en el proyecto.

## ⚙️ Instrucciones de uso

1. **Clonar el repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. **Abrir en Android Studio**:
   - Asegúrate de tener Android Studio instalado.
   - Importa el proyecto seleccionando la carpeta raíz del repositorio.

3. **Configurar dependencias**:
   - Gradle instalará automáticamente las dependencias necesarias.

4. **Ejecutar la aplicación**:
   - Conecta un dispositivo físico o inicia un emulador.
   - Haz clic en el botón "Run" o utiliza el atajo `Shift + F10`.

## 📈 Futuras mejoras

- Introducir nuevos ingredientes y opciones personalizables.
- Incorporar un sistema de ranking para los pedidos más frecuentes.
- Añadir animaciones y sonidos para una experiencia más inmersiva.

---

¡Descubre tu kebab perfecto con esta aplicación interactiva y fácil de usar! Si tienes sugerencias o quieres contribuir, no dudes en enviar tus ideas.

## 📝 Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).
