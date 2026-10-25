package com.p038google.p061crypto.p062tink.p065config;

import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;

/* loaded from: classes.dex */
public final class TinkFips {
    private TinkFips() {
    }

    public static void restrictToFips() {
        Registry.restrictToFipsIfEmpty();
    }

    public static boolean useOnlyFips() {
        return TinkFipsUtil.useOnlyFips();
    }
}
