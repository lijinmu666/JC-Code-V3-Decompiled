package p094kotlin.p105jvm.internal;

import java.io.Serializable;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Function;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function10;
import p094kotlin.p105jvm.functions.Function11;
import p094kotlin.p105jvm.functions.Function12;
import p094kotlin.p105jvm.functions.Function13;
import p094kotlin.p105jvm.functions.Function14;
import p094kotlin.p105jvm.functions.Function15;
import p094kotlin.p105jvm.functions.Function16;
import p094kotlin.p105jvm.functions.Function17;
import p094kotlin.p105jvm.functions.Function18;
import p094kotlin.p105jvm.functions.Function19;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function20;
import p094kotlin.p105jvm.functions.Function21;
import p094kotlin.p105jvm.functions.Function22;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.functions.Function6;
import p094kotlin.p105jvm.functions.Function7;
import p094kotlin.p105jvm.functions.Function8;
import p094kotlin.p105jvm.functions.Function9;

@Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "This class is no longer supported, do not use it.")
@Deprecated
/* loaded from: classes.dex */
public abstract class FunctionImpl implements Function, Serializable, Function0, Function1, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21, Function22 {
    private void checkArity(int i) {
        if (getArity() != i) {
            throwWrongArity(i);
        }
    }

    private void throwWrongArity(int i) {
        throw new IllegalStateException("Wrong function arity, expected: " + i + ", actual: " + getArity());
    }

    public abstract int getArity();

    @Override // p094kotlin.p105jvm.functions.Function0
    /* renamed from: invoke */
    public Object mo4323invoke() {
        checkArity(0);
        return invokeVararg(new Object[0]);
    }

    public Object invokeVararg(Object... objArr) {
        throw new UnsupportedOperationException();
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke */
    public Object mo2237invoke(Object obj) {
        checkArity(1);
        return invokeVararg(obj);
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public Object mo2167invoke(Object obj, Object obj2) {
        checkArity(2);
        return invokeVararg(obj, obj2);
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke */
    public Object mo6219invoke(Object obj, Object obj2, Object obj3) {
        checkArity(3);
        return invokeVararg(obj, obj2, obj3);
    }

    @Override // p094kotlin.p105jvm.functions.Function4
    /* renamed from: invoke */
    public Object mo6276invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        checkArity(4);
        return invokeVararg(obj, obj2, obj3, obj4);
    }

    @Override // p094kotlin.p105jvm.functions.Function5
    /* renamed from: invoke */
    public Object mo6277invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        checkArity(5);
        return invokeVararg(obj, obj2, obj3, obj4, obj5);
    }

    @Override // p094kotlin.p105jvm.functions.Function6
    /* renamed from: invoke */
    public Object mo6278invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        checkArity(6);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // p094kotlin.p105jvm.functions.Function7
    /* renamed from: invoke */
    public Object mo6279invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        checkArity(7);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // p094kotlin.p105jvm.functions.Function8
    /* renamed from: invoke */
    public Object mo6280invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        checkArity(8);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // p094kotlin.p105jvm.functions.Function9
    /* renamed from: invoke */
    public Object mo6281invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        checkArity(9);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // p094kotlin.p105jvm.functions.Function10
    /* renamed from: invoke */
    public Object mo6263invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        checkArity(10);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // p094kotlin.p105jvm.functions.Function11
    /* renamed from: invoke */
    public Object mo6264invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        checkArity(11);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // p094kotlin.p105jvm.functions.Function12
    /* renamed from: invoke */
    public Object mo6265invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        checkArity(12);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // p094kotlin.p105jvm.functions.Function13
    /* renamed from: invoke */
    public Object mo6266invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        checkArity(13);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // p094kotlin.p105jvm.functions.Function14
    /* renamed from: invoke */
    public Object mo6267invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        checkArity(14);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // p094kotlin.p105jvm.functions.Function15
    /* renamed from: invoke */
    public Object mo6268invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        checkArity(15);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // p094kotlin.p105jvm.functions.Function16
    /* renamed from: invoke */
    public Object mo6269invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        checkArity(16);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // p094kotlin.p105jvm.functions.Function17
    /* renamed from: invoke */
    public Object mo6270invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        checkArity(17);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // p094kotlin.p105jvm.functions.Function18
    /* renamed from: invoke */
    public Object mo6271invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        checkArity(18);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // p094kotlin.p105jvm.functions.Function19
    /* renamed from: invoke */
    public Object mo6272invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        checkArity(19);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // p094kotlin.p105jvm.functions.Function20
    /* renamed from: invoke */
    public Object mo6273invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        checkArity(20);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // p094kotlin.p105jvm.functions.Function21
    /* renamed from: invoke */
    public Object mo6274invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        checkArity(21);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // p094kotlin.p105jvm.functions.Function22
    /* renamed from: invoke */
    public Object mo6275invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        checkArity(22);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
