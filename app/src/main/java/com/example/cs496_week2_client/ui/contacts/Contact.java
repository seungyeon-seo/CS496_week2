package com.example.cs496_week2_client.ui.contacts;

import android.util.Log;

public class Contact implements Comparable<Contact> {
    String phone, fullName, lookup = null;
    long personId;
    String image = null;

    public Contact(String ph, String fn, String bytes, long pid, String key) {
        phone = ph;
        fullName = fn;
        if (bytes != null)  image = bytes;
        personId = pid;
        lookup = key;
    }

    /* Useful Functions */
    public boolean isStartWith (String str) {
        return phone.startsWith(str);
    }
    public String getMsg() {
        return ("name=" + fullName + ", phone=" + phone);
    }

    @Override
    public int compareTo(Contact o) {
        if (this.fullName.compareTo(o.fullName) > 0)
            return 1;
        Log.i("Contact", "Compare result: 0");
        return 0;
    }
}