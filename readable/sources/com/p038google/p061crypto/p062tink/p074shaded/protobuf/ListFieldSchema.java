package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    public static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        /* renamed from: getList */
        public static <E> List<E> m4070getList(Object obj, long j) {
            return (List) UnsafeUtil.getObject(obj, j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public void makeImmutableListAt(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j, objUnmodifiableList);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List listM4070getList = m4070getList(obj2, j);
            List listMutableListAt = mutableListAt(obj, j, listM4070getList.size());
            int size = listMutableListAt.size();
            int size2 = listM4070getList.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(listM4070getList);
            }
            if (size > 0) {
                listM4070getList = listMutableListAt;
            }
            UnsafeUtil.putObject(obj, j, listM4070getList);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> mutableListAt(Object obj, long j, int i) {
            LazyStringArrayList lazyStringArrayList;
            List<L> listM4070getList = m4070getList(obj, j);
            if (listM4070getList.isEmpty()) {
                List<L> lazyStringArrayList2 = listM4070getList instanceof LazyStringList ? new LazyStringArrayList(i) : ((listM4070getList instanceof PrimitiveNonBoxingCollection) && (listM4070getList instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) listM4070getList).mutableCopyWithCapacity2(i) : new ArrayList<>(i);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList2);
                return lazyStringArrayList2;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(listM4070getList.getClass())) {
                ArrayList arrayList = new ArrayList(listM4070getList.size() + i);
                arrayList.addAll(listM4070getList);
                UnsafeUtil.putObject(obj, j, arrayList);
                lazyStringArrayList = arrayList;
            } else {
                if (!(listM4070getList instanceof UnmodifiableLazyStringList)) {
                    if (!(listM4070getList instanceof PrimitiveNonBoxingCollection) || !(listM4070getList instanceof Internal.ProtobufList)) {
                        return listM4070getList;
                    }
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) listM4070getList;
                    if (protobufList.isModifiable()) {
                        return listM4070getList;
                    }
                    Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(listM4070getList.size() + i);
                    UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity2);
                    return protobufListMutableCopyWithCapacity2;
                }
                LazyStringArrayList lazyStringArrayList3 = new LazyStringArrayList(listM4070getList.size() + i);
                lazyStringArrayList3.addAll((UnmodifiableLazyStringList) listM4070getList);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList3);
                lazyStringArrayList = lazyStringArrayList3;
            }
            return lazyStringArrayList;
        }
    }

    public static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        public static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity2(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(obj, j, protobufList2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListFieldSchema
        public <L> List<L> mutableListAt(Object obj, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity2);
            return protobufListMutableCopyWithCapacity2;
        }
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    /* renamed from: full */
    public static ListFieldSchema m4068full() {
        return FULL_INSTANCE;
    }

    /* renamed from: lite */
    public static ListFieldSchema m4069lite() {
        return LITE_INSTANCE;
    }

    public abstract void makeImmutableListAt(Object obj, long j);

    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    public abstract <L> List<L> mutableListAt(Object obj, long j);

    private ListFieldSchema() {
    }
}
