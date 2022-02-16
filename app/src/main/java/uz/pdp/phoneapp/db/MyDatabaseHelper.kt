package uz.pdp.phoneapp.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.pdp.phoneapp.model.Phone
import uz.pdp.phoneapp.utils.Constant

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.PHONE} text not null, ${Constant.PHONE_TYPE} text not null, ${Constant.FEATURE} text not null);"
        db?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(p0)
    }
    fun addPhone(phone: Phone){
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.PHONE,phone.phone)
        contentValues.put(Constant.PHONE_TYPE,phone.phone_type)
        contentValues.put(Constant.FEATURE,phone.features)
        database.insert(Constant.TABLE_NAME, null,contentValues)
        database.close()
    }
    fun getAllPhones(): ArrayList<Phone>{
        var phones = ArrayList<Phone>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val phone = cursor.getString(1)
                val phone_type = cursor.getString(2)
                val phone_feature = cursor.getString(3)

                val ph = Phone(id,phone,phone_type,phone_feature)
                phones.add(ph)
            }while (cursor.moveToNext())
        }
        return phones
    }
    @SuppressLint("Recycle")
    fun getPhoneTypes(check: String): ArrayList<Phone>{
        var phones = ArrayList<Phone>()
        val database = this.readableDatabase
        val query = "select * from ${Constant.TABLE_NAME} where "+Constant.PHONE+" = ?"
        val cursor = database.rawQuery(query, arrayOf(check))
        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val phone = cursor.getString(1)
                val phone_type = cursor.getString(2)
                val phone_feature = cursor.getString(3)

                val ph = Phone(id,phone,phone_type,phone_feature)
                phones.add(ph)
            }while (cursor.moveToNext())
        }
        return phones
    }
}