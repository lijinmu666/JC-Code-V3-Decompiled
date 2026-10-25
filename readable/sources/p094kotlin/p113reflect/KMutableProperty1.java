package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p113reflect.KMutableProperty;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000eJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H¦\u0080\u0004¢\u0006\u0002\u0010\tR\u001f\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, m4988d2 = {"Lkotlin/reflect/KMutableProperty1;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/KMutableProperty;", "set", BuildConfig.f24315FLAVOR, "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "setter", "Lkotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "Setter", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    @Metadata(m4987d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m4988d2 = {"Lkotlin/reflect/KMutableProperty1$Setter;", "T", "V", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.reflect.KMutableProperty1$Setter */
    public interface InterfaceC1245Setter<T, V> extends KMutableProperty.InterfaceC1243Setter<V>, Function2<T, V, C1133Unit> {
    }

    @Override // p094kotlin.p113reflect.KMutableProperty, p094kotlin.p113reflect.KMutableProperty0
    InterfaceC1245Setter<T, V> getSetter();

    /* renamed from: set */
    void mo6327set(T receiver, V value);
}
