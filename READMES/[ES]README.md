
# Descripción corta

Un downloader con una función unicamente de estudio.

Utilidades del downloader:

# Por parte del "atacante":

Paquer: Es la clase que otorga los métodos para embeber el código en imagenes.

Unpaquer: Proporciona una interfaz sencilla para utilizar los métodos de la clase Paquer.


# Por parte del target:

Unpaquer: Esta clase proporciona los métodos necesarios para sacar el código embebido de las imágenes, tambíen es la clase que se ocupa de lanzar el código.

DownloadCode: Es la clase que descarga el código y que proporciona (de forma automática) la posibilidad de actualizar el código (Se explica mas adelante). Cuando descarga el código llama automaticamente a los métodos necesarios de la clase Unpaquer.


# Funcionamiento por parte del servidor.

Se debe montar un servidor web en el que se administrarán las imágenes y las versiones. Este servidor debe contener: 

·Un archivo "index.html" con el nombre de la imagen.
·Un archivo llamado "versión" con un número de versión, esto es necesario por si alguna vez es necesario actualizar el código o cambiarlo, cambiando este número el downloader cambiará automaticamente el código por el contenido en la imagen.
·La imagen con el código embebido.

# Funcionamiento por parte del cliente.

Esto son solo unas modificaciones sencillas que hay que hacer en el código antes de lanzarlo:

En el archivo Unpaquer: sustituir "DireccionAlmacenamiento" por una dirección de almacenamiento en las líneas 50 y 54 , es posible dejarlo así.

En el archivo DownloadCode: sustituir "DirecciónWeb" por la dirección URL de su servidor en las líneas 67 y 75.
