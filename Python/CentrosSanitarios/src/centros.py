# -*- coding: utf-8 -*-
'''
Created on 18 nov. 2020

@author: alegestor
'''
import csv
from collections import namedtuple
from coordenadas import *

CentroSanitario = namedtuple('CentroSanitario', 'nombre, localidad, coordenada, estado, num_camas, acceso_minusvalidos, tiene_uci')

def lee_centroSanitario(fichero):
    '''
    ENTRADA: 
       - fichero: nombre del fichero de entrada -> str
       
    SALIDA: 
       - lista de tuplas CentroSanitario(nombre, localidad, coordenada, estado, num_camas, acceso_minusvalidos, tiene_uci) -> [(str, str, tupla Coordenada(float,float), str, int, bool, bool)]
    '''
    registros = []
    with open(fichero, encoding = 'utf-8') as f:
        lector = csv.reader(f,delimiter = ';')
        next(lector)
        for nombre, localidad, latitud, longitud, estado, num_camas, acceso_minusvalidos, tiene_uci in lector:
            nombre = nombre.strip()
            localidad = localidad.strip()
            latitud = float(latitud)
            longitud = float(latitud)
            coordenada = Coordenada(latitud, longitud)
            estado = estado.strip()
            num_camas = int(num_camas)
            acceso_minusvalidos = eval(acceso_minusvalidos.strip().capitalize()) #Como pasar de un string falso a boolean falso
            tiene_uci = eval(tiene_uci.strip().capitalize()) #Como pasar de un string falso a boolean falso
            tupla = CentroSanitario(nombre, localidad, coordenada, estado, num_camas, acceso_minusvalidos, tiene_uci)
            registros.append(tupla)
    return registros