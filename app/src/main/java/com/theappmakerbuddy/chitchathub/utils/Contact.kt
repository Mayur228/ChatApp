package com.theappmakerbuddy.chitchathub.utils

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.theappmakerbuddy.chitchathub.MainActivity

data class Contact(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val photo: String?
)

@Composable
fun getContactList(): State<List<Contact>> {
    val context = LocalContext.current
    val contactsState = mutableStateOf<List<Contact>>(emptyList())

    MainActivity().checkAndRequestPermission(
        android.Manifest.permission.READ_CONTACTS,
        onPermissionGranted = {
            contactsState.value = fetchContacts(context.contentResolver)
        },
        onPermissionDenied = {
            // Handle the case when any permission is denied
        }
    )

    return contactsState
}

@SuppressLint("Range")
private fun fetchContacts(contentResolver: ContentResolver): List<Contact> {
    val contacts = mutableListOf<Contact>()

    val cursor = contentResolver.query(
        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        null,
        null,
        null,
        null
    )

    cursor?.use {
        while (it.moveToNext()) {
            val id = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID))
            val name = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val phoneNumber = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            val photoUri = it.getString(it.getColumnIndex(ContactsContract.Contacts.PHOTO_URI))

            contacts.add(Contact(id, name, phoneNumber,photoUri))
        }
    }

    return contacts
}
