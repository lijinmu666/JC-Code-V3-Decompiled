package com.p038google.p061crypto.p062tink.integration.p069android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.p038google.p061crypto.p062tink.KeysetReader;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0865Hex;
import java.io.CharConversionException;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetReader implements KeysetReader {
    private final String keysetName;
    private final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
        }
    }

    private byte[] readPref() throws CharConversionException, FileNotFoundException {
        try {
            String string = this.sharedPreferences.getString(this.keysetName, null);
            if (string != null) {
                return C0865Hex.m4274decode(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.keysetName));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.keysetName));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    /* renamed from: read */
    public C0675Keyset mo3324read() {
        return C0675Keyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    public EncryptedKeyset readEncrypted() {
        return EncryptedKeyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }
}
