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
print('1.3')
# cursor.execute("SELECT * FROM characters")
cursor.execute("SELECT * FROM characters RIGHT JOIN anime ON characters.animeFK = anime.id")
for x in cursor:
    if x[0] == 4 or x[0] == 3:
        id = x
        print(id, sep=" ")
# 1.4
# anime = "INSERT INTO anime (id, title, numOfVolume) VALUES(%s, %s, %s)"
# valA = ('id(edit)', 'ชื่อเรื่อง(edit)', 'จำนวนตอน(edit)')#กำหนดค่า id, title, numOfVolume
# cursor.execute(anime, valA)#ส่งข้อมูลanimeไปท่ี่ตารางanime
# characters = "INSERT INTO characters (id, fName, lName, popularity, animeFK) VALUES(%s, %s, %s, %s, %s)"
# valC = ('รหัส(edit)', 'Name(edit)', 'LastName(edit)', 'popularity(edit)', 'มาจากเรื่อง id ไหน') #กำหนดค่า id, fName, lName, popularity, animeFK
# cursor.execute(characters, valC)#ส่งข้อมูลCharactersไปท่ี่ตารางcharacter
# บรรทัดที่commentไว้ใช้สำหรับใส้ข้อมูล
# 1.4
print('1.4')
cursor.execute("SELECT * FROM characters RIGHT JOIN anime ON characters.animeFK = anime.id")
for x in cursor:
    if x[0] == 504260 or x[0] == 504261:
        id = x
        print(id, sep=" ")
# 1.5
print('1.5')
cursor.execute("SELECT * FROM characters RIGHT JOIN anime ON characters.animeFK = anime.id")
for x in cursor:
    id = x[0]
    fName = x[1]
    lName = x[2]
    popularity = x[3]
    animeTitle = x[6]  # เกิดขึ้นได้เพราะเอาตารางหลังมาjoin
    if x[0] == 504260 or x[0] == 504261:
        print(id, fName, lName, popularity, animeTitle, sep=" ")
cursor.close()
# my_con.commit() #อย่าไปยุ่งกับมันถ้ายังไม่เสร็จสมบูรณ์
my_con.close()
