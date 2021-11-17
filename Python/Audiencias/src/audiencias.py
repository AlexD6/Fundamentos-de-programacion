# -*- coding: utf-8 -*-
'''
Created on 16 oct. 2020

@author: alegestor
'''

import csv
from collections import namedtuple

Audiencia = namedtuple('Audiencias', 'edicion,audiencia')

def lee_audiencias(fichero):
    registros = []
    with open(fichero, encoding = 'utf-8') as f:
        lector = csv.reader(f)
        for edicion, audiencia in lector:
            registros.append(Audiencia(int(edicion), float(audiencia)))
    return registros
