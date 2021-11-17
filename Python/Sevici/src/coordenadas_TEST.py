# -*- coding: utf-8 -*-
'''
Created on 18 nov. 2020

@author: alegestor
'''
from coordenadas import *

################################################################
#  Funciones de test
################################################################
def test_calcular_distancia(coordenada1,coordenada2):
    distancia = calcular_distancia(coordenada1, coordenada2)
    print('La distancia entre coordenadas {} y {} es {}'.format(coordenada1, coordenada2, distancia))
    
def test_calcular_media_coordenadas(coordenadas):
    media = calcular_media_coordenadas(coordenadas)
    print('La coordenada media es {}'.format(media))
    
################################################################
#  Programa principal
################################################################
if __name__ == '__main__':

    coord1 = Coordenada(12.3, 6.8)
    coord2 = Coordenada(6.8, 90.22)
    coordenadas = [coord1,coord2]

#     test_calcular_distancia(coord1,coord2)
    test_calcular_media_coordenadas(coordenadas)
