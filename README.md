## Escuela Colombiana de Ingeniería

## Arquitecturas de Software

# Componentes y conectores - Parte I.

## Integrantes
### Hann Jang

El ejercicio se debe traer terminado para el siguiente laboratorio (Parte II).

#### Middleware- gestión de planos.


## Antes de hacer este ejercicio, realice [el ejercicio introductorio al manejo de Spring y la configuración basada en anotaciones](https://github.com/ARSW-ECI/Spring_LightweightCont_Annotation-DI_Example).

En este ejercicio se va a construír un modelo de clases para la capa lógica de una aplicación que permita gestionar planos arquitectónicos de una prestigiosa compañia de diseño. 

![](img/ClassDiagram1.png)

1. Configure la aplicación para que funcione bajo un esquema de inyección de dependencias, tal como se muestra en el diagrama anterior.    

Lo anterior requiere:  
* __Agregar las dependencias de Spring.__  
  
	La dependencia de Spring se agrega en el archivo pom.xml, en la sección de dependencias, se agrega la dependencia de Spring, en este caso se agrega la dependencia de Spring Core y Spring Context.

* __Agregar la configuración de Spring.__

	Se agregaron las anotaciones @Service y @Autowired en la clase BlueprintServices para que Spring pueda inyectar la dependencia de la clase BlueprintPersistence.


* __Configurar la aplicación -mediante anotaciones- para que el esquema de persistencia sea inyectado al momento de ser creado el bean 'BlueprintServices'.__  

	Se agregó la anotación @Service en las clases que iban a inyectarse, o que son dependencias.

2. __Complete los operaciones getBluePrint() y getBlueprintsByAuthor(). Implemente todo lo requerido de las capas inferiores (por ahora, el esquema de persistencia disponible 'InMemoryBlueprintPersistence') agregando las pruebas correspondientes en 'InMemoryPersistenceTest'.__  

	Se completaron las operaciones getBluePrint() y getBlueprintsByAuthor() en la clase BlueprintServices, y se implementaron las pruebas correspondientes en la clase InMemoryPersistenceTest.

3. __Haga un programa en el que cree (mediante Spring) una instancia de BlueprintServices, y rectifique la funcionalidad del mismo: registrar planos, consultar planos, registrar planos específicos, etc.__  
	
	Se creó una clase de prueba llamada Main, en la cual se creó una instancia de BlueprintServices mediante Spring, y se probaron las funcionalidades de registrar planos, consultar planos y registrar planos específicos.

	![img.png](img%2Fimg.png)


4. __Se quiere que las operaciones de consulta de planos realicen un proceso de filtrado, antes de retornar los planos consultados. Dichos filtros lo que buscan es reducir el tamaño de los planos, removiendo datos redundantes o simplemente submuestrando, antes de retornarlos. Ajuste la aplicación (agregando las abstracciones e implementaciones que considere) para que a la clase BlueprintServices se le inyecte uno de dos posibles 'filtros' (o eventuales futuros filtros). No se contempla el uso de más de uno a la vez:__    

	* __(A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.__
	* __(B) Filtrado de submuestreo: suprime 1 de cada 2 puntos del plano, de manera intercalada.__  
   
5. __Agrege las pruebas correspondientes a cada uno de estos filtros, y pruebe su funcionamiento en el programa de prueba, comprobando que sólo cambiando la posición de las anotaciones -sin cambiar nada más-, el programa retorne los planos filtrados de la manera (A) o de la manera (B).__  

	Se crearon las clases RedundanciasBlueprintFilter y SubmuestreoBlueprintFilter, las cuales implementan la interfaz BlueprintFilter, y se agregaron las anotaciones @Service en las clases para que Spring pueda inyectar las dependencias.

	![img_1.png](img%2Fimg_1.png)
