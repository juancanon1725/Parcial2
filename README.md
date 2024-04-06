# Parcial2

## Juan Pablo Poveda Cañon

## Descripción

Consiste una aplicación desarrollada en Java que ofrece servicios para llevar a cabo búsquedas lineales y binarias en listas de números enteros. Además, cuenta con un proxy de servicio diseñado para dirigir las solicitudes de búsqueda hacia diversos servidores, con la finalidad de distribuir equitativamente la carga entre ellos.

## Instalación

1. Clonar el repositorio.
   
`git clone https://github.com/juancanon1725/Parcial2.git`

2. Instalación con mvn.

`mvn clean install`

## Ejecucion en AWS

- Se crean las instancias para cada servicio.
- 
![AWSinstancias](https://github.com/juancanon1725/Parcial2/assets/98672541/3c61a4ec-4573-406f-bc8c-fe411c559dd2)

- Se corre cada servicio con:
  
  (Para MathServices)
  `java -cp "target/classes:target/dependency/*" org.example.MathServices`

   (Para ProxyService)
  `java -cp "target/classes:target/dependency/*" org.example.ProxyService`
  
![image](https://github.com/juancanon1725/Parcial2/assets/98672541/51a6712f-e0e2-4b61-91a8-8077ff4dcda1)

Video Explicativo:

[Ejecución en AWS](https://youtu.be/QqCFb6AGtak)


## Arquitectura

En la arquitectura encontramos servicios como:
- MathServices que permite buscar en una lista de dos distintas maneras (lineal y binaria).
- ProxyService se convierte en un servicio que permite conectar todas las clases.
  
![img](https://github.com/juancanon1725/Parcial2/assets/98672541/804eb05b-8f48-4219-9ec9-1747e191d0c7)
