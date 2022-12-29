import mysql.connector
my_con = mysql.connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)
print('connected!')
cursor = my_con.cursor()

# 1.3
print('\nprinting character names showing only lastname')
cursor.execute("SELECT * FROM characters RIGHT JOIN anime ON characters.animeFK = anime.id")
for x in cursor:
    if x[0] == 3 or x[0] == 4 :
        print(x, sep=" ")

# 1.4
# characters = "INSERT INTO characters (id, fName, lName, popularity, animeFK) VALUES(%s , %s, %s, %s, %s)"
# abcde = (501470, 'Nobita', 'Nobisuge', 42, 24)
# cursor.execute(characters, abcde)
# cursor.execute("SELECT * FROM characters")
# for x in cursor:
#     if x[0] == 501470 :
#         print(x, sep=" ")

# 1.5
cursor.execute("SELECT * FROM characters RIGHT JOIN anime ON characters.animeFK = anime.id")
for x in cursor:
    if x[0] == 501470 :
        print(x[0], x[1], x[2], x[3], x[4], x[6], x[7], sep=" ")

# print('\nprinting anime names')
# cursor.execute("SELECT * FROM anime")
# for y in cursor:
#     id = y[0]
#     print(id, y[1], sep=" ")

cursor.close()
# my_con.commit()
my_con.close()
