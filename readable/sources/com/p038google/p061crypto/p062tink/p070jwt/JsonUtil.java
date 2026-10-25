package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.internal.JsonParser;
import java.io.IOException;
import p131o.C3858i0;
import p131o.C4385q0;
import p131o.C4454r0;

/* loaded from: classes.dex */
final class JsonUtil {
    private JsonUtil() {
    }

    public static boolean isValidString(String str) {
        return JsonParser.isValidString(str);
    }

    public static C4385q0 parseJson(String str) throws JwtInvalidException {
        try {
            return JsonParser.m3480parse(str).m12832lgHUyS();
        } catch (IOException | IllegalStateException | C4454r0 e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    public static C3858i0 parseJsonArray(String str) throws JwtInvalidException {
        try {
            return JsonParser.m3480parse(str).m12836xJ();
        } catch (IOException | IllegalStateException | C4454r0 e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }
}
