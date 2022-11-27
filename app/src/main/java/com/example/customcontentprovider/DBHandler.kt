package com.example.customcontentprovider

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(
    context: Context?,
    dbname: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, dbname, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY, " +
                "username TEXT, " +
                "password TEXT)"

        db!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun getUser(projection : Array<String>?,
                selectionClause : String?,
                selectionArgs : Array<String>?,
                sortOrder : String?) : Cursor {
        return readableDatabase.query("user",
            projection,
            selectionClause,
            selectionArgs,
            null,
            null,
            sortOrder)
    }


}