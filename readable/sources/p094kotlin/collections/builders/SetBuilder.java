package p094kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.AbstractMutableSet;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.p106markers.KMutableSet;

@Metadata(m4987d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001(B\u001b\b@\u0012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tB\t\bV¢\u0006\u0004\b\b\u0010\nB\u0011\bV\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0082\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0082\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u0013H\u0096\u0080\u0004J\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u001dJ\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0096\u0082\u0004J\u0018\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bJ\u0018\u0010&\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bJ\u0018\u0010'\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bR\u0019\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, m4988d2 = {"Lkotlin/collections/builders/SetBuilder;", "E", BuildConfig.f24315FLAVOR, "Lkotlin/collections/AbstractMutableSet;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "()V", "initialCapacity", BuildConfig.f24315FLAVOR, "(I)V", "build", BuildConfig.f24315FLAVOR, "writeReplace", BuildConfig.f24315FLAVOR, "readObject", BuildConfig.f24315FLAVOR, "input", "Ljava/io/ObjectInputStream;", "size", "getSize", "()I", "isEmpty", BuildConfig.f24315FLAVOR, "contains", "element", "(Ljava/lang/Object;)Z", "clear", "add", "remove", "iterator", BuildConfig.f24315FLAVOR, "addAll", "elements", BuildConfig.f24315FLAVOR, "removeAll", "retainAll", "Companion", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Set<E>, Serializable, KMutableSet {
    private static final Companion Companion = new Companion(null);

    /* renamed from: Empty */
    private static final SetBuilder f5009Empty = new SetBuilder(MapBuilder.INSTANCE.getEmpty$kotlin_stdlib());
    private final MapBuilder<E, ?> backing;

    @Metadata(m4987d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m4988d2 = {"Lkotlin/collections/builders/SetBuilder$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "Empty", "Lkotlin/collections/builders/SetBuilder;", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SetBuilder(MapBuilder<E, ?> backing) {
        Intrinsics.checkNotNullParameter(backing, "backing");
        this.backing = backing;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.backing.getIsReadOnly()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // p094kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E element) {
        return this.backing.addKey$kotlin_stdlib(element) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(elements);
    }

    /* renamed from: build */
    public final Set<E> m6018build() {
        this.backing.m6012build();
        return size() > 0 ? this : f5009Empty;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object element) {
        return this.backing.containsKey(element);
    }

    @Override // p094kotlin.collections.AbstractMutableSet
    /* renamed from: getSize */
    public int mo5121getSize() {
        return this.backing.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object element) {
        return this.backing.removeKey$kotlin_stdlib(element);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int i) {
        this(new MapBuilder(i));
    }
}
