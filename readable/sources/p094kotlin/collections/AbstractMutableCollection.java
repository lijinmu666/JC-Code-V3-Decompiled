package p094kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.p106markers.KMutableCollection;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H§\u0080\bb\u0002\b\n¢\u0006\u0002\u0010\tÊ\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¨\u0006\u000b"}, m4988d2 = {"Lkotlin/collections/AbstractMutableCollection;", "E", BuildConfig.f24315FLAVOR, "Ljava/util/AbstractCollection;", "<init>", "()V", "add", BuildConfig.f24315FLAVOR, "element", "(Ljava/lang/Object;)Z", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractMutableCollection<E> extends AbstractCollection<E> implements Collection<E>, KMutableCollection {
    @Override // java.util.AbstractCollection, java.util.Collection
    @IgnorableReturnValue
    public abstract boolean add(E element);

    /* renamed from: getSize */
    public abstract int mo5117getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return mo5117getSize();
    }
}
