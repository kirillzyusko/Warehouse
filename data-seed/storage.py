import random

random.seed(1234)
ids = [2,14,108,564,1484,2756,3168,3420,3984,4617,4741,4901,5718,7259,7324,7403,8683,9477,9867,10109,10899,11592,11800,12327,13135,13959,15037,16124,16336,16825,17971,18515,18574,18601,19964,20163,20266,20550,20722,20858,20886,21110,21737,22459,22586,22747,22783,23162,23674,23991,24181,24380,24600,25483,25565,26487,26497,26578,27591,28986,29193,29739,30717,30722,30815,32795,33226,34051,35339,35464,35487,35608,36049,36471,37764,38617,39423,39447,39580,39856,40210,41247,41646,41873,42075,42477,44041,44920,45062,45427,45502,46263,46278,46567,48104,48991,49582,49728,49877,50385,50466,51666,51671,51893,52507,53843,53951,54015,54123,54246,55172,55279,55689,55875,57445,58145,58513,58534,58659,58740,58918,59347,59398,60248,60361,60525,61384,62449,62775,64060,64099,66434,67190,67673,68340,68920,69440,69896,70121,70238,70302,70567,71109,71250,71638,72255,73051,73223,73897,75133,75254,76666,77101,77137,77872,79441,79823,81678,81918,82551,82624,82782,82832,85129,86279,86394,86828,86903,87127,87319,87349,88555,90376,91044,91274,91857,93467,93536,93640,94105,94392,94480,94597,94715,94774,94928,95296,95547,96175,98178,98912,99358,99862,100531,100762,101972,103327,103517,103678,104062,104287,104717,104794,104934,105247,107023,107095,107111,107699,108121,108454,109033,109156,110021,110114,110729,112578,113323,113546,113820,113938,114057,114068,114118,114228,114559,114598,115832,118012,118046,118196,118349,118621,118948,120156,120249,121061,121161,121876,122075,122325,122978,122991,123509,123663,123861,124498,124574,125082,126151,126154,126518,126641,126976,127955,128637,129041,129200,130230,130372,130688,132248,132508,133266,133600,134489,135001,135165,136089,136252,137030,137205,137641,137930,138475,139137,139345,140269,140448,141666,141673,142645,142732,143512,145250,145435,148101,149263,149840,150222,150758,152144,152340,152435,152515,152542,152734,152852,152881,153974,154010,154378,154657,154922,154940,155400,155741,156704,156780,156816,157962,158357,158598,159015,159323,159821,159957,160248,160268,161043,161301,161477,161771,162779,163151,164094,164733,164786,167660,167839,168904,170092,170343,170623,170650,171636,172065,172079,172314,173076,174399,174467,175657,175666,176735,178278,178581,178624,179205,179751,180280,180659,181304,181471,181752,181989,183015,183798,184022,184533,185022,185547,185834,185915,186580,186933,187334,188115,188808,189183,189505,189650,190583,190884,191881,192065,192256,195303,195734,195763,195949,196295,196350,197201,197243,197773,198344,198803,199356,199805,200382,200547,202056,202791,202854,204299,205164,205862,206031,206104,207119,208026,208382,209567,210838,213462,213796,214786,215217,216879,218135,219689,221918,222572,222926,222950,223718,224765,225361,225597,226434,227099,227411,228348,228709,229717,230009,230298,230566,230944,230965,232258,232755,233725,234198,235360,235503,235822,235906,236478,236917,237458,237541,237697,238111,238269,239539,240267,240464,240481,240881,241225,241252,241308,247195,248288,248451,248469,248673,249030,249065,249093,249096,249362,249514,251843,252489,252512,253474,253649,255255,255379,256616,257008,257646,260136,260146,260543,261141,261212,261688,261704,261956,262287,262801,263190,263251,263521,264055,264428,264451,265080,265361,265704,265970,266150,266304,266391,266415,266548,267467,267488,268051,268577,269024,269201,269629,272763,272826,275107,276515,276536,276546,276898,277066,277904,277984,278410,279794,279957,279975,280139,280549,282213,282661,282991,283286,283320,283739,284561,285720,285968,286194,286494,287723,287818,288050,288192,289152,289322,289774,289831,289852,290418,290761,292080,292187,292229,292289,292372,292499,293118,294309,294568,294613,294973,295800,296542,297078,298981,299124,299827,301511,301754,301906,301978,302356,303603,304016,304372,305074,306227,306341,306568,306686,307666,309441,310762,310891,311631,312428,312648,313786,313974,314000,314360,314764,314848,316077,316756,317586,319896,320579,321175,321780,322689,324173,324899,327046,327078,327500,327670,327756,328042,328936,330462,330900,331091,331522,332092,334303,336303,336910,337108,337305,337498,338061,338878,339001,339568,341571,341719,342942,343039,343159,344286,344570,345816,345852,345862,346087,346793,346884,347345,347440,347538,348279,349225,349371,350950,351035,352346,352649,353366,353851,354082,354612,354624,355519,356436,356862,357173,357296,357433,357633,357773,357983,359231,359266,359696,360343,360377,360829,361481,363600,364232,364305,364475,364505,365842,366168,366211,366832,367204,367262,367286,367472,367571,367589,368432,368673,369317,371078,372567,372699,372710,373112,373158,373572,373878,373977,374212,374426,375190,375645,376645,376847,376970,378555,378636,378836,378884,379220,379286,379937,381626,382359,382583,382727,382851,383210,383261,383357,383390,383449,384536,384632,384815,385347,388680,388732,390081,390705,390877,391066,391080,391328,391341,393018,393168,394840,395771,395981,396078,396390,396571,396618,397827,398612,400326,400400,400661,400832,401216,401402,401736,402930,403146,405810,405990,406020,406097,406451,406824,407742,407894,409572,409704,410166,411146,411318,412285,412541,413381,414825,415331,415510,416164,416848,417223,418057,418486,418729,418813,419631,420652,422125,422834,423906,424258,424667,424790,425224,426993,427073,427213,427411,427822,428223,429975,432404,433623,433825,434050,434080,434625,435136,435744,435908,437867,438319,439959,440266,440273,440292,440327,441623,442012,442593,442906,443319,443608,443912,444040,444926,445131,445737,446054,446163,446571,447040,447257,448319,448617,448815,450349,451387,451582,451762,452138,452451,453040,453628,454234,454429,454497,454550,454773,455204,456645,457063,457097,457389,457783,458874,460880,461700,461713,461880,462535,463253,463400,463695,463882,464840,465514]
next_storage_space_id = 42

for k in range(204, 204 + len(ids), 1): # for list of warehouses
    index = k - 204
    warehouse_id = ids[index]
    version = "%04d" % (k,)
    # for given id of warehouses
    amount_of_spaces = random.randrange(1, 31, 1) # 2
    cells_in_spaces = []
    for i in range(amount_of_spaces):
        cells_in_spaces.append(random.randrange(20, 301, 1)) # [100, 302]

    with open(f"../data-analysis-module/flyway/sql/V{version}__added_storages_for_warehouse{warehouse_id}_.sql", "w") as text_file:
        for i in range(amount_of_spaces):
            space_type = random.randrange(1, 6, 1)
            text_file.write(f'INSERT INTO `storage_space` (id_storage_space_type, status, id_warehouse) VALUES ({space_type}, 1, {warehouse_id});\n')
            text_file.write(f'INSERT INTO `storage_cell` (number, status, id_storage_space, id_goods) VALUES ')
            next_storage_space_id += 1
            first_record = True
            for k in range(cells_in_spaces[i]):
                if not first_record:
                    text_file.write(',\n')
                text_file.write(f'({k+1},1,{next_storage_space_id},NULL)')

                if first_record:
                    first_record = False
            text_file.write(';\n')
