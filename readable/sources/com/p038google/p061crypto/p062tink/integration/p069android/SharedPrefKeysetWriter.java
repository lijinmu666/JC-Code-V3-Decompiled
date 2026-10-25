package com.p038google.p061crypto.p062tink.integration.p069android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.p038google.p061crypto.p062tink.KeysetWriter;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p075subtle.C0865Hex;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetWriter implements KeysetWriter {

    /* renamed from: editor */
    private final SharedPreferences.Editor f3105editor;
    private final String keysetName;

    public SharedPrefKeysetWriter(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.f3105editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.f3105editor = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3326write(C0675Keyset c0675Keyset) throws IOException {
        if (!this.f3105editor.putString(this.keysetName, C0865Hex.m4275encode(c0675Keyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3325write(EncryptedKeyset encryptedKeyset) throws IOException {
        if (!this.f3105editor.putString(this.keysetName, C0865Hex.m4275encode(encryptedKeyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
