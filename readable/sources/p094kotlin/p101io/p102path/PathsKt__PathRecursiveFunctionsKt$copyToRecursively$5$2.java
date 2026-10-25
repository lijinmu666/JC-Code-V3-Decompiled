package p094kotlin.p101io.p102path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
    final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
    final /* synthetic */ Path $normalizedTarget;
    final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;

    /* renamed from: $stack */
    final /* synthetic */ ArrayList<Path> f5145$stack;

    /* renamed from: $target */
    final /* synthetic */ Path f5146$target;
    final /* synthetic */ Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(ArrayList<Path> arrayList, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
        super(2, Intrinsics.C1233Kotlin.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        this.f5145$stack = arrayList;
        this.$copyAction = function3;
        this.$this_copyToRecursively = path;
        this.f5146$target = path2;
        this.$normalizedTarget = path3;
        this.$onError = function32;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final FileVisitResult mo2167invoke(Path p0, BasicFileAttributes p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(this.f5145$stack, this.$copyAction, this.$this_copyToRecursively, this.f5146$target, this.$normalizedTarget, this.$onError, p0, p1);
    }
}
