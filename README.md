# Parcial2

## Juan Pablo Poveda Cañon

## Descripción

Consiste una aplicación desarrollada en Java que ofrece servicios para llevar a cabo búsquedas lineales y binarias en listas de números enteros. Además, cuenta con un proxy de servicio diseñado para dirigir las solicitudes de búsqueda hacia diversos servidores, con la finalidad de distribuir equitativamente la carga entre ellos.

## Instalación

1. Clonar el repositorio.
   
`git clone https://github.com/juancanon1725/Parcial2.git`

2. Instalación con mvn.

`mvn install`

## Ejecucion en AWS

![AWSinstancias](https://github.com/juancanon1725/Parcial2/assets/98672541/3c61a4ec-4573-406f-bc8c-fe411c559dd2)


## Arquitectura

En la arquitectura encontramos servicios como:
- MathServices que permite buscar en una lista de dos distintas maneras (lineal y binaria).
- ProxyService se convierte en un servicio que permite conectar todas las clases.
![img](https://github.com/juancanon1725/Parcial2/assets/98672541/804eb05b-8f48-4219-9ec9-1747e191d0c7)
