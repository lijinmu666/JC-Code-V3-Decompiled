package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.lang.reflect.Field;

@CheckReturnValue
/* loaded from: classes.dex */
final class OneofInfo {
    private final Field caseField;

    /* renamed from: id */
    private final int f3741id;
    private final Field valueField;

    public OneofInfo(int i, Field field, Field field2) {
        this.f3741id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    /* renamed from: getId */
    public int m4112getId() {
        return this.f3741id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
