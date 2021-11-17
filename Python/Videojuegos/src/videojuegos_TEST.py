'''
Created on 6 ene. 2021

@author: alget
'''

from videojuegos import *

################################################################
#  tests
################################################################


def test_lee_juegos(datos):
    print ("Leídos ...", len(datos), "videojuegos")
    print("Los tres primeros registros son:", datos[:3], '\n')

    # Test de la función lee_juegos
    # La salida esperada es:
    # Número total de videojuegos: 16291
    # Mostrando los tres primeros registros leídos:
    # Juego(rank=1, name='Wii Sports', platform='Wii', year=2006, genre='Sports', publisher='Nintendo',
    # NA_sales=41.49, EU_sales=29.02, JP_sales=3.77, other_sales=8.46, global_sales=82.74),
    # Juego(rank=2, name='Super Mario Bros.', platform='NES', year=1985, genre='Platform', publisher='Nintendo',
    # NA_sales=29.08, EU_sales=3.58, JP_sales=6.81, other_sales=0.77, global_sales=40.24),
    # Juego(rank=3, name='Mario Kart Wii', platform='Wii', year=2008, genre='Racing', publisher='Nintendo',
    # NA_sales=15.85, EU_sales=12.88, JP_sales=3.79, other_sales=3.31, global_sales=35.82)]


def test_num_juegos_mas_ventasJP(datos):
    print("Número de videojuegos con más ventas en Japón que en Norteamérica: ", num_juegos_mas_ventasJP(datos), '\n')
    # Test de la función existe_mas_ventasJP
    # La salida esperada es:
    # Número de videojuegos con más ventas en Japón que en Norteamérica: 4078


def test_juegos_distribuidora_anyo(datos):
    publisher = 'Microsoft Game Studios'
    anyo = 2005
    print("La salida esperada para la distribuidora 'Microsoft Game Studios' y el año 2005 es: ", juegos_distribuidora_anyo(datos, publisher, anyo), '\n')
    # Test de la función juegos_distribuidora_anyo
    # La salida esperada para la distribuidora 'Microsoft Game Studios' y el año 2005 es:
    # Mostrando los 14 juegos distribuidos por Microsoft Game Studios en el año 2005:
    # ['Forza Motorsport', 'Perfect Dark Zero', 'Conker: Live And Reloaded', 'Jade Empire',
    # 'Halo 2 Multiplayer Map Pack', 'PGR3 - Project Gotham Racing 3', 'Age of Empires III',
    # 'Kameo: Elements of Power', 'Halo Triple Pack', 'Ninja Gaiden Black', 'Fable: The Lost Chapters',
    # 'Tecmo Classic Arcade', 'Tork: Prehistoric Punk', 'Dungeon Siege II']



def test_num_distribuidoras(datos):
    print("Número de distribuidoras distintas: ", num_distribuidoras(datos), '\n')
    # Test de la función num_distribuidoras
    # La salida esperada es:
    # Número de distribuidoras distintas: 576



def test_juego_mas_antiguo(datos):
    print("El juego (o juegos) más antiguo es: ", juego_mas_antiguo(datos), '\n')
    # Test de la función juego_mas_antiguo
    # La salida esperada es:
    # El juego (o juegos) más antiguo es: [Juego(rank=259, name='Asteroids', platform='2600', year=1980,
    # genre='Shooter', publisher='Atari', NA_sales=4.0, EU_sales=0.26, JP_sales=0.0, other_sales=0.05, global_sales=4.31),
    # Juego(rank=545, name='Missile Command', platform='2600', year=1980, genre='Shooter', publisher='Atari',
    # NA_sales=2.56, EU_sales=0.17, JP_sales=0.0, other_sales=0.03, global_sales=2.76), Juego(rank=1768, name='Kaboom!',
    # platform='2600', year=1980, genre='Misc', publisher='Activision', NA_sales=1.07, EU_sales=0.07, JP_sales=0.0,
    # other_sales=0.01, global_sales=1.15), Juego(rank=1971, name='Defender', platform='2600', year=1980, genre='Misc',
    # publisher='Atari', NA_sales=0.99, EU_sales=0.05, JP_sales=0.0, other_sales=0.01, global_sales=1.05),
    # Juego(rank=2671, name='Boxing', platform='2600', year=1980, genre='Fighting', publisher='Activision',
    # NA_sales=0.72, EU_sales=0.04, JP_sales=0.0, other_sales=0.01, global_sales=0.77), Juego(rank=4027,
    # name='Ice Hockey', platform='2600', year=1980, genre='Sports', publisher='Activision', NA_sales=0.46,
    # EU_sales=0.03, JP_sales=0.0, other_sales=0.01, global_sales=0.49), Juego(rank=5368, name='Freeway',
    # platform='2600', year=1980, genre='Action', publisher='Activision', NA_sales=0.32, EU_sales=0.02, JP_sales=0.0,
    # other_sales=0.0, global_sales=0.34), Juego(rank=6319, name='Bridge', platform='2600', year=1980, genre='Misc',
    # publisher='Activision', NA_sales=0.25, EU_sales=0.02, JP_sales=0.0, other_sales=0.0, global_sales=0.27),
    # Juego(rank=6898, name='Checkers', platform='2600', year=1980, genre='Misc', publisher='Atari', NA_sales=0.22,
    # EU_sales=0.01, JP_sales=0.0, other_sales=0.0, global_sales=0.24)]



def test_genero_mas_presente(datos):
    print("El género que se repite más es: ", genero_mas_presente(datos), '\n')
    # Test de la función genero_mas_presente
    # La salida esperada es:
    # El género que se repite más es "Action" con 3251 copias

def test_genero_mas_ventas(datos):
    print("El género con más ventas es: ", genero_mas_ventas(datos), '\n')
    # Test de la función genero_mas_ventas
    # La salida esperada es:
    # El género con más ventas es "Action" con 1722.839999999971 millones de copias



def test_num_juegos_palabra(datos):
    palabra = 'sport'
    print("La salida esperada para la palabra 'sport' es: ", num_juegos_palabra(datos, palabra), '\n')
    # Test de la función num_juegos_palabra
    # La salida esperada para la palabra 'sport' es:
    # Hay 11 juegos que contienen la palabra sport



def test_mayor_dif_NA_EU(datos):
    print("El juego con mayor diferencia de ventas entre Europa y Norteamérica es: ", mayor_dif_NA_EU(datos), '\n')
    # Test de la función mayor_dif_NA_EU
    # La salida esperada es:
    # El juego con mayor diferencia de ventas entre Europa y Norteamérica es: World of Warcraft
    pass


def test_ventas_por_año(datos):
    print("Ventas por año: ", ventas_por_año(datos), '\n')
    # Test de la función ventas_por_año
    # La salida esperada para es:
    # Ventas por año:
    # [(2008, 678.8999999999952), (2009, 667.2999999999947), (2007, 609.9199999999935),
    # (2010, 600.2899999999948), (2006, 521.0399999999917), (2011, 515.7999999999972),
    # (2005, 458.50999999999766), (2004, 414.0099999999987), (2002, 395.5199999999983),
    # (2013, 368.10999999999865), (2012, 363.4899999999984), (2003, 357.8499999999989),
    # (2014, 337.0299999999985), (2001, 331.4699999999991), (2015, 264.43999999999795),
    # (1998, 256.46999999999963), (1999, 251.27000000000018), (2000, 201.5600000000002),
    # (1997, 200.98000000000013), (1996, 199.14999999999995), (1995, 88.10999999999991),
    # (1994, 79.17000000000003), (1992, 76.15999999999998), (1989, 73.45),
    # (2016, 70.90000000000013), (1985, 53.940000000000005), (1984, 50.360000000000014),
    # (1990, 49.38999999999999), (1988, 47.22), (1993, 45.98), (1986, 37.07),
    # (1981, 35.77000000000001), (1991, 32.230000000000004), (1982, 28.859999999999996),
    # (1987, 21.739999999999995), (1983, 16.790000000000003), (1980, 11.379999999999999),
    # (2020, 0.29), (2017, 0.05)]


def test_dicc_porcentaje_ventasJP_por_año(datos):
    print("Porcentajes anuales de ventas en Japón respecto al total: ", dicc_porcentaje_ventasJP_por_año(datos), '\n')
    # Test de la función dicc_porcentaje_ventasJP_por_año
    # La salida esperada es:
    # Porcentajes anuales de ventas en Japón respecto al total: {1980: 0.0, 1981: 0.0, 1982: 0.0,
    # 1983: 48.24300178677784, 1984: 28.335980937251776, 1985: 26.992955135335556, 1986: 53.439438899379546,
    # 1987: 53.49586016559339, 1988: 33.37568826768318, 1989: 24.996596324029955, 1990: 30.12755618546265,
    # 1991: 45.857896369841754, 1992: 37.95955882352942, 1993: 55.08916920400176, 1994: 42.932929139825696,
    # 1995: 51.92373169901267, 1996: 28.84258096911875, 1997: 24.315852323614262, 1998: 19.511053924435636,
    # 1999: 20.830182672026094, 2000: 21.219487993649533, 2001: 12.0252209853079, 2002: 10.558252427184517,
    # 2003: 9.557076987564662, 2004: 10.060143474795325, 2005: 11.838345946653352, 2006: 14.150545063718937,
    # 2007: 9.884902938090365, 2008: 8.876123140374201, 2009: 9.274689045406934, 2010: 9.910210065135306,
    # 2011: 10.283055447848074, 2012: 14.234229277284204, 2013: 12.928200809540689, 2014: 11.708156543927918,
    # 2015: 12.751474814702915, 2016: 19.28067700987298, 2017: 100.0, 2020: 0.0}


def test_incremento_ventas(datos):
    print("Incremento anual de las ventas globales: ", incremento_ventas(datos), '\n')
    # Test de la función incremento_ventas
    # La salida esperada es:
    # Incremento anual de las ventas globales: [214.32337434094913, -19.317864131954188, -41.822591822591804,
    # 199.94044073853487, 7.108816521048431, -31.275491286614763, -41.354194766657685, 117.20331186752534,
    # 55.54849639983059, -32.756977535738606, -34.743875278396416, 136.30158237666762, -39.62710084033613,
    # 72.1835580687256, 11.292156119742176, 126.02428782204079, 0.9189053477279355, 27.609712409194678,
    # -2.027527586072233, -19.783499820909757, 64.45227227624468, 19.323015657525367, -9.524170711973998,
    # 15.693726421685056, 10.748532644138818, 13.637652395802562, 17.058191309688937, 11.309679958027687,
    # -1.708646339667191, -10.041960137869085, -14.074863815822077, -29.528887165567976, 1.2710115821618895,
    # -8.443128412702798, -21.538142005163003, -73.18862501890763, -99.92947813822285, 480.0]


def test_juego_mas_ventas_globales_saga(datos):
    saga = 'Pokemon'
    print("El juego con más ventas de la saga Pokemon: ", juego_mas_ventas_globales_saga(datos, saga), '\n')
    # Test de la función juego_mas_ventas_globales_saga
    # La salida esperada para la saga 'Pokemon' es:
    # El juego con más ventas de la saga Pokemon con 31.37 millones de copias es Pokemon Red/Pokemon Blue del año 1996


def test_dicc_ventas_por_zona(datos):
    print("El total de ventas por zona para los años (1985, 1999) es: ", dicc_ventas_por_zona(datos, 1985, 1999), '\n')
    print("El total de ventas por zona para los años (None, 1990) es: ", dicc_ventas_por_zona(datos, None, 1990), '\n')
    print("El total de ventas por zona para los años (1999, None) es: ", dicc_ventas_por_zona(datos, 1999), '\n')
    print("El total de ventas por zona para los años (None, None) es: ", dicc_ventas_por_zona(datos), '\n')
    # Test de la función dicc_ventas_por_zona
    # La salida esperada es:
    # El total de ventas por zona para los años (1985, 1999) es:
    # {'América': 699.8199999999937, 'Europa': 306.88999999999623, 'Japón': 452.4499999999998, 'Otros': 52.959999999999916}
    # El total de ventas por zona para los años (None, 1990) es:
    # {'América': 261.12, 'Europa': 38.83000000000008, 'Japón': 117.36999999999999, 'Otros': 8.529999999999982}
    # El total de ventas por zona para los años (1999, None) es:
    # {'América': 3641.940000000276, 'Europa': 2155.2900000003197, 'Japón': 861.7899999999548, 'Otros': 744.4099999998928}
    # El total de ventas por zona para los años (None, None) es:
    # {'América': 4327.650000000327, 'Europa': 2406.690000000536, 'Japón': 1284.2699999999031, 'Otros': 788.9099999998845}


def test_dicc_top_n_juegos_por_genero(datos):
    print("Los 3 mejores juegos de cada género son: ", dicc_top_n_juegos_por_genero(datos, 3), '\n')
    # Test de la función dicc_top_n_juegos_por_genero
    # La salida esperada para n=3 es:
    # Los 3 mejores juegos de cada género son:
    # Sports : [(1, 'Wii Sports'), (4, 'Wii Sports Resort'), (14, 'Wii Fit')]
    # Platform : [(2, 'Super Mario Bros.'), (7, 'New Super Mario Bros.'), (9, 'New Super Mario Bros. Wii')]
    # Racing : [(3, 'Mario Kart Wii'), (12, 'Mario Kart DS'), (29, 'Gran Turismo 3: A-Spec')]
    # Role-Playing : [(5, 'Pokemon Red/Pokemon Blue'), (13, 'Pokemon Gold/Pokemon Silver'), (21, 'Pokemon Diamond/Pokemon Pearl')]
    # Puzzle : [(6, 'Tetris'), (28, 'Brain Age 2: More Training in Minutes a Day'), (90, 'Pac-Man')]
    # Misc : [(8, 'Wii Play'), (16, 'Kinect Adventures!'), (20, 'Brain Age: Train Your Brain in Minutes a Day')]
    # Shooter : [(10, 'Duck Hunt'), (30, 'Call of Duty: Modern Warfare 3'), (32, 'Call of Duty: Black Ops')]
    # Simulation : [(11, 'Nintendogs'), (42, 'Animal Crossing: Wild World'), (74, 'Animal Crossing: New Leaf')]
    # Action : [(17, 'Grand Theft Auto V'), (18, 'Grand Theft Auto: San Andreas'), (24, 'Grand Theft Auto V')]
    # Fighting : [(40, 'Super Smash Bros. Brawl'), (98, 'Super Smash Bros. for Wii U and 3DS'), (106, 'Tekken 3')]
    # Adventure : [(51, 'Super Mario Land 2: 6 Golden Coins'), (159, "Assassin's Creed"), (219, "Assassin's Creed")]
    # Strategy : [(166, 'Pokemon Stadium'), (205, 'Warzone 2100'), (218, 'StarCraft II: Wings of Liberty')]


def test_dibuja_ventas_por_zona(datos):
    print("La salida esperada para las ventas entre los años 1985 y 1999 es la gráfica: ", dibuja_ventas_por_zona(datos, 1985, 1999), '\n')
#     # Test de la función dibuja_ventas_por_zona
#     # La salida esperada para las ventas entre los años 1985 y 1999 es la gráfica que está en una imagen a parte
    


def test_distribuidora_mas_juegos_genero(datos):
    genero = 'Role-Playing'
    print("La distribuidora con más juegos del género Role-Playing es: ", distribuidora_mas_juegos_genero(datos, genero), '\n')
    # Test de la función distribuidora_mas_juegos_genero
    # La salida esperada es:
    # La distribuidora con más juegos del género Role-Playing es Namco Bandai Games


def test_juegos_distinto_ranking_EU_NA(datos):
    print("Los juegos que están entre los 3 más vendidos solo en Europa o Norteamérica son: ", juegos_distinto_ranking_EU_NA(datos, 3), '\n')
    # Test de la función distribuidora_mas_juegos_genero
    # Test de la función juegos_distinto_ranking_EU_NA
    # La salida esperada para n = 3 es:
    # Los juegos que están entre los 3 más vendidos solo en Europa o Norteamérica son:
    # {Juego(rank=2, name='Super Mario Bros.', platform='NES', year=1985, genre='Platform', publisher='Nintendo',
    # NA_sales=29.08, EU_sales=3.58, JP_sales=6.81, other_sales=0.77, global_sales=40.24),
    # Juego(rank=4, name='Wii Sports Resort', platform='Wii', year=2009, genre='Sports', publisher='Nintendo',
    # NA_sales=15.75, EU_sales=11.01, JP_sales=3.28, other_sales=2.96, global_sales=33.0),
    # Juego(rank=10, name='Duck Hunt', platform='NES', year=1984, genre='Shooter', publisher='Nintendo',
    # NA_sales=26.93, EU_sales=0.63, JP_sales=0.28, other_sales=0.47, global_sales=28.31),
    # Juego(rank=3, name='Mario Kart Wii', platform='Wii', year=2008, genre='Racing', publisher='Nintendo',
    # NA_sales=15.85, EU_sales=12.88, JP_sales=3.79, other_sales=3.31, global_sales=35.82)}


def test_juegos_mismo_ranking_EU_NA_JP(datos):
    print("Los juegos que están entre los 12 más vendidos a la vez en Europa, Norteamérica y Japón son: ", juegos_mismo_ranking_EU_NA_JP(datos, 12), '\n')
    # Test de la función juegos_mismo_ranking_EU_NA_JP
    # La salida esperada para n = 12 es:
    # Los juegos que están entre los 12 más vendidos a la vez en Europa, Norteamérica y Japón son:
    # {Juego(rank=7, name='New Super Mario Bros.', platform='DS', year=2006, genre='Platform', publisher='Nintendo',
    # NA_sales=11.38, EU_sales=9.23, JP_sales=6.5, other_sales=2.9, global_sales=30.01),
    # Juego(rank=5, name='Pokemon Red/Pokemon Blue', platform='GB', year=1996, genre='Role-Playing', publisher='Nintendo',
    # NA_sales=11.27, EU_sales=8.89, JP_sales=10.22, other_sales=1.0, global_sales=31.37)}


def test_primer_juego_distinto(datos):
    print("Los dos videojuegos de mayor venta que ocupan posiciones diferentes en Europa y Norteamérica son: ", primer_juego_distinto(datos), '\n')
    # Test de la función primer_juego_distinto
    # La salida esperada es:
    # Los dos videojuegos de mayor venta que ocupan posiciones diferentes en Europa y Norteamérica son:
    # (Juego(rank=2, name='Super Mario Bros.', platform='NES', year=1985, genre='Platform', publisher='Nintendo',
    # NA_sales=29.08, EU_sales=3.58, JP_sales=6.81, other_sales=0.77, global_sales=40.24),
    # Juego(rank=3, name='Mario Kart Wii', platform='Wii', year=2008, genre='Racing', publisher='Nintendo',
    # NA_sales=15.85, EU_sales=12.88, JP_sales=3.79, other_sales=3.31, global_sales=35.82))


################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    VIDEOJUEGOS = lee_juegos('../data/videojuegos.csv')
    print('##############################################################')
    print('# EJERCICIO 1:')
    print('##############################################################')
    test_lee_juegos(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 2:')
    print('##############################################################')
    test_num_juegos_mas_ventasJP(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 3:')
    print('##############################################################')
    test_juegos_distribuidora_anyo(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 4:')
    print('##############################################################')
    test_num_distribuidoras(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 5:')
    print('##############################################################')
    test_juego_mas_antiguo(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 6:')
    print('##############################################################')
    test_genero_mas_presente(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 7:')
    print('##############################################################')
    test_genero_mas_ventas(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 8:')
    print('##############################################################')
    test_num_juegos_palabra(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 9:')
    print('##############################################################')
    test_mayor_dif_NA_EU(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 10:')
    print('##############################################################')
    test_ventas_por_año(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 11:')
    print('##############################################################')
    test_dicc_porcentaje_ventasJP_por_año(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 12:')
    print('##############################################################')
    test_incremento_ventas(VIDEOJUEGOS
    )
    print('##############################################################')
    print('# EJERCICIO 13:')
    print('##############################################################')
    test_juego_mas_ventas_globales_saga(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 14:')
    print('##############################################################')
    test_dicc_ventas_por_zona(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 15:')
    print('##############################################################')
    test_dicc_top_n_juegos_por_genero(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 16:')
    print('##############################################################')
#     test_dibuja_ventas_por_zona(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 17:')
    print('##############################################################')
    test_distribuidora_mas_juegos_genero(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 18:')
    print('##############################################################')
    test_juegos_distinto_ranking_EU_NA(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 19:')
    print('##############################################################')
    test_juegos_mismo_ranking_EU_NA_JP(VIDEOJUEGOS)

    print('##############################################################')
    print('# EJERCICIO 20:')
    print('##############################################################')
    test_primer_juego_distinto(VIDEOJUEGOS)