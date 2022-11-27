package com.example.customcontentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {
    var database : DBHandler? = null

    val uriMatcher : UriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("com.example.customContentProvider", "user", 1)
        addURI("com.example.customContentProvider", "words", 2)
        addURI("com.example.customContentProvider", "words/#", 3)
    }
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to delete one or more rows")
    }

    override fun getType(uri: Uri): String? {
        TODO(
            "Implement this to handle requests for the MIME type of the data" +
                    "at the given URI"
        )
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    override fun onCreate(): Boolean {
        database = DBHandler(context, "users", null, 1)
        return false
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        var cursor : Cursor? = null
        if(uriMatcher.match(uri) == 1){
            cursor = database!!.getUser(projection, selection, selectionArgs, sortOrder)
        }
        return cursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        TODO("Implement this to handle requests to update one or more rows.")
    }
}