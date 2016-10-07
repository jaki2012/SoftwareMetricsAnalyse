package metrics;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import metrics.Java8Parser.*;
/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class Java8BaseListener implements Java8Listener {
    public Java8BaseListener() {
    }

    public void enterLiteral(LiteralContext ctx) {
    }

    public void exitLiteral(LiteralContext ctx) {
    }

    public void enterType(TypeContext ctx) {
    }

    public void exitType(TypeContext ctx) {
    }

    public void enterPrimitiveType(PrimitiveTypeContext ctx) {
    }

    public void exitPrimitiveType(PrimitiveTypeContext ctx) {
    }

    public void enterNumericType(NumericTypeContext ctx) {
    }

    public void exitNumericType(NumericTypeContext ctx) {
    }

    public void enterIntegralType(IntegralTypeContext ctx) {
    }

    public void exitIntegralType(IntegralTypeContext ctx) {
    }

    public void enterFloatingPointType(FloatingPointTypeContext ctx) {
    }

    public void exitFloatingPointType(FloatingPointTypeContext ctx) {
    }

    public void enterReferenceType(ReferenceTypeContext ctx) {
    }

    public void exitReferenceType(ReferenceTypeContext ctx) {
    }

    public void enterClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
    }

    public void exitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
    }

    public void enterClassType(ClassTypeContext ctx) {
    }

    public void exitClassType(ClassTypeContext ctx) {
    }

    public void enterClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext ctx) {
    }

    public void exitClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext ctx) {
    }

    public void enterClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext ctx) {
    }

    public void exitClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext ctx) {
    }

    public void enterInterfaceType(InterfaceTypeContext ctx) {
    }

    public void exitInterfaceType(InterfaceTypeContext ctx) {
    }

    public void enterInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext ctx) {
    }

    public void exitInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext ctx) {
    }

    public void enterInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
    }

    public void exitInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
    }

    public void enterTypeVariable(TypeVariableContext ctx) {
    }

    public void exitTypeVariable(TypeVariableContext ctx) {
    }

    public void enterArrayType(ArrayTypeContext ctx) {
    }

    public void exitArrayType(ArrayTypeContext ctx) {
    }

    public void enterDims(DimsContext ctx) {
    }

    public void exitDims(DimsContext ctx) {
    }

    public void enterTypeParameter(TypeParameterContext ctx) {
    }

    public void exitTypeParameter(TypeParameterContext ctx) {
    }

    public void enterTypeParameterModifier(TypeParameterModifierContext ctx) {
    }

    public void exitTypeParameterModifier(TypeParameterModifierContext ctx) {
    }

    public void enterTypeBound(TypeBoundContext ctx) {
    }

    public void exitTypeBound(TypeBoundContext ctx) {
    }

    public void enterAdditionalBound(AdditionalBoundContext ctx) {
    }

    public void exitAdditionalBound(AdditionalBoundContext ctx) {
    }

    public void enterTypeArguments(TypeArgumentsContext ctx) {
    }

    public void exitTypeArguments(TypeArgumentsContext ctx) {
    }

    public void enterTypeArgumentList(TypeArgumentListContext ctx) {
    }

    public void exitTypeArgumentList(TypeArgumentListContext ctx) {
    }

    public void enterTypeArgument(TypeArgumentContext ctx) {
    }

    public void exitTypeArgument(TypeArgumentContext ctx) {
    }

    public void enterWildcard(WildcardContext ctx) {
    }

    public void exitWildcard(WildcardContext ctx) {
    }

    public void enterWildcardBounds(WildcardBoundsContext ctx) {
    }

    public void exitWildcardBounds(WildcardBoundsContext ctx) {
    }

    public void enterPackageName(PackageNameContext ctx) {
    }

    public void exitPackageName(PackageNameContext ctx) {
    }

    public void enterTypeName(TypeNameContext ctx) {
    }

    public void exitTypeName(TypeNameContext ctx) {
    }

    public void enterPackageOrTypeName(PackageOrTypeNameContext ctx) {
    }

    public void exitPackageOrTypeName(PackageOrTypeNameContext ctx) {
    }

    public void enterExpressionName(ExpressionNameContext ctx) {
    }

    public void exitExpressionName(ExpressionNameContext ctx) {
    }

    public void enterMethodName(MethodNameContext ctx) {
    }

    public void exitMethodName(MethodNameContext ctx) {
    }

    public void enterAmbiguousName(AmbiguousNameContext ctx) {
    }

    public void exitAmbiguousName(AmbiguousNameContext ctx) {
    }

    public void enterCompilationUnit(CompilationUnitContext ctx) {
    }

    public void exitCompilationUnit(CompilationUnitContext ctx) {
    }

    public void enterPackageDeclaration(PackageDeclarationContext ctx) {
    }

    public void exitPackageDeclaration(PackageDeclarationContext ctx) {
    }

    public void enterPackageModifier(PackageModifierContext ctx) {
    }

    public void exitPackageModifier(PackageModifierContext ctx) {
    }

    public void enterImportDeclaration(ImportDeclarationContext ctx) {
    }

    public void exitImportDeclaration(ImportDeclarationContext ctx) {
    }

    public void enterSingleTypeImportDeclaration(SingleTypeImportDeclarationContext ctx) {
    }

    public void exitSingleTypeImportDeclaration(SingleTypeImportDeclarationContext ctx) {
    }

    public void enterTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext ctx) {
    }

    public void exitTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext ctx) {
    }

    public void enterSingleStaticImportDeclaration(SingleStaticImportDeclarationContext ctx) {
    }

    public void exitSingleStaticImportDeclaration(SingleStaticImportDeclarationContext ctx) {
    }

    public void enterStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext ctx) {
    }

    public void exitStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext ctx) {
    }

    public void enterTypeDeclaration(TypeDeclarationContext ctx) {
    }

    public void exitTypeDeclaration(TypeDeclarationContext ctx) {
    }

    public void enterClassDeclaration(ClassDeclarationContext ctx) {
    }

    public void exitClassDeclaration(ClassDeclarationContext ctx) {
    }

    public void enterNormalClassDeclaration(NormalClassDeclarationContext ctx) {
    }

    public void exitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
    }

    public void enterClassModifier(ClassModifierContext ctx) {
    }

    public void exitClassModifier(ClassModifierContext ctx) {
    }

    public void enterTypeParameters(TypeParametersContext ctx) {
    }

    public void exitTypeParameters(TypeParametersContext ctx) {
    }

    public void enterTypeParameterList(TypeParameterListContext ctx) {
    }

    public void exitTypeParameterList(TypeParameterListContext ctx) {
    }

    public void enterSuperclass(SuperclassContext ctx) {
    }

    public void exitSuperclass(SuperclassContext ctx) {
    }

    public void enterSuperinterfaces(SuperinterfacesContext ctx) {
    }

    public void exitSuperinterfaces(SuperinterfacesContext ctx) {
    }

    public void enterInterfaceTypeList(InterfaceTypeListContext ctx) {
    }

    public void exitInterfaceTypeList(InterfaceTypeListContext ctx) {
    }

    public void enterClassBody(ClassBodyContext ctx) {
    }

    public void exitClassBody(ClassBodyContext ctx) {
    }

    public void enterClassBodyDeclaration(ClassBodyDeclarationContext ctx) {
    }

    public void exitClassBodyDeclaration(ClassBodyDeclarationContext ctx) {
    }

    public void enterClassMemberDeclaration(ClassMemberDeclarationContext ctx) {
    }

    public void exitClassMemberDeclaration(ClassMemberDeclarationContext ctx) {
    }

    public void enterFieldDeclaration(FieldDeclarationContext ctx) {
    }

    public void exitFieldDeclaration(FieldDeclarationContext ctx) {
    }

    public void enterFieldModifier(FieldModifierContext ctx) {
    }

    public void exitFieldModifier(FieldModifierContext ctx) {
    }

    public void enterVariableDeclaratorList(VariableDeclaratorListContext ctx) {
    }

    public void exitVariableDeclaratorList(VariableDeclaratorListContext ctx) {
    }

    public void enterVariableDeclarator(VariableDeclaratorContext ctx) {
    }

    public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
    }

    public void enterVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
    }

    public void exitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
    }

    public void enterVariableInitializer(VariableInitializerContext ctx) {
    }

    public void exitVariableInitializer(VariableInitializerContext ctx) {
    }

    public void enterUnannType(UnannTypeContext ctx) {
    }

    public void exitUnannType(UnannTypeContext ctx) {
    }

    public void enterUnannPrimitiveType(UnannPrimitiveTypeContext ctx) {
    }

    public void exitUnannPrimitiveType(UnannPrimitiveTypeContext ctx) {
    }

    public void enterUnannReferenceType(UnannReferenceTypeContext ctx) {
    }

    public void exitUnannReferenceType(UnannReferenceTypeContext ctx) {
    }

    public void enterUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext ctx) {
    }

    public void exitUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext ctx) {
    }

    public void enterUnannClassType(UnannClassTypeContext ctx) {
    }

    public void exitUnannClassType(UnannClassTypeContext ctx) {
    }

    public void enterUnannClassType_lf_unannClassOrInterfaceType(UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
    }

    public void exitUnannClassType_lf_unannClassOrInterfaceType(UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
    }

    public void enterUnannClassType_lfno_unannClassOrInterfaceType(UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
    }

    public void exitUnannClassType_lfno_unannClassOrInterfaceType(UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
    }

    public void enterUnannInterfaceType(UnannInterfaceTypeContext ctx) {
    }

    public void exitUnannInterfaceType(UnannInterfaceTypeContext ctx) {
    }

    public void enterUnannInterfaceType_lf_unannClassOrInterfaceType(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
    }

    public void exitUnannInterfaceType_lf_unannClassOrInterfaceType(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
    }

    public void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
    }

    public void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
    }

    public void enterUnannTypeVariable(UnannTypeVariableContext ctx) {
    }

    public void exitUnannTypeVariable(UnannTypeVariableContext ctx) {
    }

    public void enterUnannArrayType(UnannArrayTypeContext ctx) {
    }

    public void exitUnannArrayType(UnannArrayTypeContext ctx) {
    }

    public void enterMethodDeclaration(MethodDeclarationContext ctx) {
    }

    public void exitMethodDeclaration(MethodDeclarationContext ctx) {
    }

    public void enterMethodModifier(MethodModifierContext ctx) {
    }

    public void exitMethodModifier(MethodModifierContext ctx) {
    }

    public void enterMethodHeader(MethodHeaderContext ctx) {
    }

    public void exitMethodHeader(MethodHeaderContext ctx) {
    }

    public void enterResult(ResultContext ctx) {
    }

    public void exitResult(ResultContext ctx) {
    }

    public void enterMethodDeclarator(MethodDeclaratorContext ctx) {
    }

    public void exitMethodDeclarator(MethodDeclaratorContext ctx) {
    }

    public void enterFormalParameterList(FormalParameterListContext ctx) {
    }

    public void exitFormalParameterList(FormalParameterListContext ctx) {
    }

    public void enterFormalParameters(FormalParametersContext ctx) {
    }

    public void exitFormalParameters(FormalParametersContext ctx) {
    }

    public void enterFormalParameter(FormalParameterContext ctx) {
    }

    public void exitFormalParameter(FormalParameterContext ctx) {
    }

    public void enterVariableModifier(VariableModifierContext ctx) {
    }

    public void exitVariableModifier(VariableModifierContext ctx) {
    }

    public void enterLastFormalParameter(LastFormalParameterContext ctx) {
    }

    public void exitLastFormalParameter(LastFormalParameterContext ctx) {
    }

    public void enterReceiverParameter(ReceiverParameterContext ctx) {
    }

    public void exitReceiverParameter(ReceiverParameterContext ctx) {
    }

    public void enterThrows_(Throws_Context ctx) {
    }

    public void exitThrows_(Throws_Context ctx) {
    }

    public void enterExceptionTypeList(ExceptionTypeListContext ctx) {
    }

    public void exitExceptionTypeList(ExceptionTypeListContext ctx) {
    }

    public void enterExceptionType(ExceptionTypeContext ctx) {
    }

    public void exitExceptionType(ExceptionTypeContext ctx) {
    }

    public void enterMethodBody(MethodBodyContext ctx) {
    }

    public void exitMethodBody(MethodBodyContext ctx) {
    }

    public void enterInstanceInitializer(InstanceInitializerContext ctx) {
    }

    public void exitInstanceInitializer(InstanceInitializerContext ctx) {
    }

    public void enterStaticInitializer(StaticInitializerContext ctx) {
    }

    public void exitStaticInitializer(StaticInitializerContext ctx) {
    }

    public void enterConstructorDeclaration(ConstructorDeclarationContext ctx) {
    }

    public void exitConstructorDeclaration(ConstructorDeclarationContext ctx) {
    }

    public void enterConstructorModifier(ConstructorModifierContext ctx) {
    }

    public void exitConstructorModifier(ConstructorModifierContext ctx) {
    }

    public void enterConstructorDeclarator(ConstructorDeclaratorContext ctx) {
    }

    public void exitConstructorDeclarator(ConstructorDeclaratorContext ctx) {
    }

    public void enterSimpleTypeName(SimpleTypeNameContext ctx) {
    }

    public void exitSimpleTypeName(SimpleTypeNameContext ctx) {
    }

    public void enterConstructorBody(ConstructorBodyContext ctx) {
    }

    public void exitConstructorBody(ConstructorBodyContext ctx) {
    }

    public void enterExplicitConstructorInvocation(ExplicitConstructorInvocationContext ctx) {
    }

    public void exitExplicitConstructorInvocation(ExplicitConstructorInvocationContext ctx) {
    }

    public void enterEnumDeclaration(EnumDeclarationContext ctx) {
    }

    public void exitEnumDeclaration(EnumDeclarationContext ctx) {
    }

    public void enterEnumBody(EnumBodyContext ctx) {
    }

    public void exitEnumBody(EnumBodyContext ctx) {
    }

    public void enterEnumConstantList(EnumConstantListContext ctx) {
    }

    public void exitEnumConstantList(EnumConstantListContext ctx) {
    }

    public void enterEnumConstant(EnumConstantContext ctx) {
    }

    public void exitEnumConstant(EnumConstantContext ctx) {
    }

    public void enterEnumConstantModifier(EnumConstantModifierContext ctx) {
    }

    public void exitEnumConstantModifier(EnumConstantModifierContext ctx) {
    }

    public void enterEnumBodyDeclarations(EnumBodyDeclarationsContext ctx) {
    }

    public void exitEnumBodyDeclarations(EnumBodyDeclarationsContext ctx) {
    }

    public void enterInterfaceDeclaration(InterfaceDeclarationContext ctx) {
    }

    public void exitInterfaceDeclaration(InterfaceDeclarationContext ctx) {
    }

    public void enterNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
    }

    public void exitNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
    }

    public void enterInterfaceModifier(InterfaceModifierContext ctx) {
    }

    public void exitInterfaceModifier(InterfaceModifierContext ctx) {
    }

    public void enterExtendsInterfaces(ExtendsInterfacesContext ctx) {
    }

    public void exitExtendsInterfaces(ExtendsInterfacesContext ctx) {
    }

    public void enterInterfaceBody(InterfaceBodyContext ctx) {
    }

    public void exitInterfaceBody(InterfaceBodyContext ctx) {
    }

    public void enterInterfaceMemberDeclaration(InterfaceMemberDeclarationContext ctx) {
    }

    public void exitInterfaceMemberDeclaration(InterfaceMemberDeclarationContext ctx) {
    }

    public void enterConstantDeclaration(ConstantDeclarationContext ctx) {
    }

    public void exitConstantDeclaration(ConstantDeclarationContext ctx) {
    }

    public void enterConstantModifier(ConstantModifierContext ctx) {
    }

    public void exitConstantModifier(ConstantModifierContext ctx) {
    }

    public void enterInterfaceMethodDeclaration(InterfaceMethodDeclarationContext ctx) {
    }

    public void exitInterfaceMethodDeclaration(InterfaceMethodDeclarationContext ctx) {
    }

    public void enterInterfaceMethodModifier(InterfaceMethodModifierContext ctx) {
    }

    public void exitInterfaceMethodModifier(InterfaceMethodModifierContext ctx) {
    }

    public void enterAnnotationTypeDeclaration(AnnotationTypeDeclarationContext ctx) {
    }

    public void exitAnnotationTypeDeclaration(AnnotationTypeDeclarationContext ctx) {
    }

    public void enterAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
    }

    public void exitAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
    }

    public void enterAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext ctx) {
    }

    public void exitAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext ctx) {
    }

    public void enterAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext ctx) {
    }

    public void exitAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext ctx) {
    }

    public void enterAnnotationTypeElementModifier(AnnotationTypeElementModifierContext ctx) {
    }

    public void exitAnnotationTypeElementModifier(AnnotationTypeElementModifierContext ctx) {
    }

    public void enterDefaultValue(DefaultValueContext ctx) {
    }

    public void exitDefaultValue(DefaultValueContext ctx) {
    }

    public void enterAnnotation(AnnotationContext ctx) {
    }

    public void exitAnnotation(AnnotationContext ctx) {
    }

    public void enterNormalAnnotation(NormalAnnotationContext ctx) {
    }

    public void exitNormalAnnotation(NormalAnnotationContext ctx) {
    }

    public void enterElementValuePairList(ElementValuePairListContext ctx) {
    }

    public void exitElementValuePairList(ElementValuePairListContext ctx) {
    }

    public void enterElementValuePair(ElementValuePairContext ctx) {
    }

    public void exitElementValuePair(ElementValuePairContext ctx) {
    }

    public void enterElementValue(ElementValueContext ctx) {
    }

    public void exitElementValue(ElementValueContext ctx) {
    }

    public void enterElementValueArrayInitializer(ElementValueArrayInitializerContext ctx) {
    }

    public void exitElementValueArrayInitializer(ElementValueArrayInitializerContext ctx) {
    }

    public void enterElementValueList(ElementValueListContext ctx) {
    }

    public void exitElementValueList(ElementValueListContext ctx) {
    }

    public void enterMarkerAnnotation(MarkerAnnotationContext ctx) {
    }

    public void exitMarkerAnnotation(MarkerAnnotationContext ctx) {
    }

    public void enterSingleElementAnnotation(SingleElementAnnotationContext ctx) {
    }

    public void exitSingleElementAnnotation(SingleElementAnnotationContext ctx) {
    }

    public void enterArrayInitializer(ArrayInitializerContext ctx) {
    }

    public void exitArrayInitializer(ArrayInitializerContext ctx) {
    }

    public void enterVariableInitializerList(VariableInitializerListContext ctx) {
    }

    public void exitVariableInitializerList(VariableInitializerListContext ctx) {
    }

    public void enterBlock(BlockContext ctx) {
    }

    public void exitBlock(BlockContext ctx) {
    }

    public void enterBlockStatements(BlockStatementsContext ctx) {
    }

    public void exitBlockStatements(BlockStatementsContext ctx) {
    }

    public void enterBlockStatement(BlockStatementContext ctx) {
    }

    public void exitBlockStatement(BlockStatementContext ctx) {
    }

    public void enterLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext ctx) {
    }

    public void exitLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext ctx) {
    }

    public void enterLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
    }

    public void exitLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
    }

    public void enterStatement(StatementContext ctx) {
    }

    public void exitStatement(StatementContext ctx) {
    }

    public void enterStatementNoShortIf(StatementNoShortIfContext ctx) {
    }

    public void exitStatementNoShortIf(StatementNoShortIfContext ctx) {
    }

    public void enterStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext ctx) {
    }

    public void exitStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext ctx) {
    }

    public void enterEmptyStatement(EmptyStatementContext ctx) {
    }

    public void exitEmptyStatement(EmptyStatementContext ctx) {
    }

    public void enterLabeledStatement(LabeledStatementContext ctx) {
    }

    public void exitLabeledStatement(LabeledStatementContext ctx) {
    }

    public void enterLabeledStatementNoShortIf(LabeledStatementNoShortIfContext ctx) {
    }

    public void exitLabeledStatementNoShortIf(LabeledStatementNoShortIfContext ctx) {
    }

    public void enterExpressionStatement(ExpressionStatementContext ctx) {
    }

    public void exitExpressionStatement(ExpressionStatementContext ctx) {
    }

    public void enterStatementExpression(StatementExpressionContext ctx) {
    }

    public void exitStatementExpression(StatementExpressionContext ctx) {
    }

    public void enterIfThenStatement(IfThenStatementContext ctx) {
    }

    public void exitIfThenStatement(IfThenStatementContext ctx) {
    }

    public void enterIfThenElseStatement(IfThenElseStatementContext ctx) {
    }

    public void exitIfThenElseStatement(IfThenElseStatementContext ctx) {
    }

    public void enterIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext ctx) {
    }

    public void exitIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext ctx) {
    }

    public void enterAssertStatement(AssertStatementContext ctx) {
    }

    public void exitAssertStatement(AssertStatementContext ctx) {
    }

    public void enterSwitchStatement(SwitchStatementContext ctx) {
    }

    public void exitSwitchStatement(SwitchStatementContext ctx) {
    }

    public void enterSwitchBlock(SwitchBlockContext ctx) {
    }

    public void exitSwitchBlock(SwitchBlockContext ctx) {
    }

    public void enterSwitchBlockStatementGroup(SwitchBlockStatementGroupContext ctx) {
    }

    public void exitSwitchBlockStatementGroup(SwitchBlockStatementGroupContext ctx) {
    }

    public void enterSwitchLabels(SwitchLabelsContext ctx) {
    }

    public void exitSwitchLabels(SwitchLabelsContext ctx) {
    }

    public void enterSwitchLabel(SwitchLabelContext ctx) {
    }

    public void exitSwitchLabel(SwitchLabelContext ctx) {
    }

    public void enterEnumConstantName(EnumConstantNameContext ctx) {
    }

    public void exitEnumConstantName(EnumConstantNameContext ctx) {
    }

    public void enterWhileStatement(WhileStatementContext ctx) {
    }

    public void exitWhileStatement(WhileStatementContext ctx) {
    }

    public void enterWhileStatementNoShortIf(WhileStatementNoShortIfContext ctx) {
    }

    public void exitWhileStatementNoShortIf(WhileStatementNoShortIfContext ctx) {
    }

    public void enterDoStatement(DoStatementContext ctx) {
    }

    public void exitDoStatement(DoStatementContext ctx) {
    }

    public void enterForStatement(ForStatementContext ctx) {
    }

    public void exitForStatement(ForStatementContext ctx) {
    }

    public void enterForStatementNoShortIf(ForStatementNoShortIfContext ctx) {
    }

    public void exitForStatementNoShortIf(ForStatementNoShortIfContext ctx) {
    }

    public void enterBasicForStatement(BasicForStatementContext ctx) {
    }

    public void exitBasicForStatement(BasicForStatementContext ctx) {
    }

    public void enterBasicForStatementNoShortIf(BasicForStatementNoShortIfContext ctx) {
    }

    public void exitBasicForStatementNoShortIf(BasicForStatementNoShortIfContext ctx) {
    }

    public void enterForInit(ForInitContext ctx) {
    }

    public void exitForInit(ForInitContext ctx) {
    }

    public void enterForUpdate(ForUpdateContext ctx) {
    }

    public void exitForUpdate(ForUpdateContext ctx) {
    }

    public void enterStatementExpressionList(StatementExpressionListContext ctx) {
    }

    public void exitStatementExpressionList(StatementExpressionListContext ctx) {
    }

    public void enterEnhancedForStatement(EnhancedForStatementContext ctx) {
    }

    public void exitEnhancedForStatement(EnhancedForStatementContext ctx) {
    }

    public void enterEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext ctx) {
    }

    public void exitEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext ctx) {
    }

    public void enterBreakStatement(BreakStatementContext ctx) {
    }

    public void exitBreakStatement(BreakStatementContext ctx) {
    }

    public void enterContinueStatement(ContinueStatementContext ctx) {
    }

    public void exitContinueStatement(ContinueStatementContext ctx) {
    }

    public void enterReturnStatement(ReturnStatementContext ctx) {
    }

    public void exitReturnStatement(ReturnStatementContext ctx) {
    }

    public void enterThrowStatement(ThrowStatementContext ctx) {
    }

    public void exitThrowStatement(ThrowStatementContext ctx) {
    }

    public void enterSynchronizedStatement(SynchronizedStatementContext ctx) {
    }

    public void exitSynchronizedStatement(SynchronizedStatementContext ctx) {
    }

    public void enterTryStatement(TryStatementContext ctx) {
    }

    public void exitTryStatement(TryStatementContext ctx) {
    }

    public void enterCatches(CatchesContext ctx) {
    }

    public void exitCatches(CatchesContext ctx) {
    }

    public void enterCatchClause(CatchClauseContext ctx) {
    }

    public void exitCatchClause(CatchClauseContext ctx) {
    }

    public void enterCatchFormalParameter(CatchFormalParameterContext ctx) {
    }

    public void exitCatchFormalParameter(CatchFormalParameterContext ctx) {
    }

    public void enterCatchType(CatchTypeContext ctx) {
    }

    public void exitCatchType(CatchTypeContext ctx) {
    }

    public void enterFinally_(Finally_Context ctx) {
    }

    public void exitFinally_(Finally_Context ctx) {
    }

    public void enterTryWithResourcesStatement(TryWithResourcesStatementContext ctx) {
    }

    public void exitTryWithResourcesStatement(TryWithResourcesStatementContext ctx) {
    }

    public void enterResourceSpecification(ResourceSpecificationContext ctx) {
    }

    public void exitResourceSpecification(ResourceSpecificationContext ctx) {
    }

    public void enterResourceList(ResourceListContext ctx) {
    }

    public void exitResourceList(ResourceListContext ctx) {
    }

    public void enterResource(ResourceContext ctx) {
    }

    public void exitResource(ResourceContext ctx) {
    }

    public void enterPrimary(PrimaryContext ctx) {
    }

    public void exitPrimary(PrimaryContext ctx) {
    }

    public void enterPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
    }

    public void exitPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
    }

    public void enterPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext ctx) {
    }

    public void exitPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext ctx) {
    }

    public void enterPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
    }

    public void exitPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
    }

    public void enterPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext ctx) {
    }

    public void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
    }

    public void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
    }

    public void enterPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext ctx) {
    }

    public void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
    }

    public void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
    }

    public void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
    }

    public void enterClassInstanceCreationExpression(ClassInstanceCreationExpressionContext ctx) {
    }

    public void exitClassInstanceCreationExpression(ClassInstanceCreationExpressionContext ctx) {
    }

    public void enterClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext ctx) {
    }

    public void exitClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext ctx) {
    }

    public void enterClassInstanceCreationExpression_lfno_primary(ClassInstanceCreationExpression_lfno_primaryContext ctx) {
    }

    public void exitClassInstanceCreationExpression_lfno_primary(ClassInstanceCreationExpression_lfno_primaryContext ctx) {
    }

    public void enterTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext ctx) {
    }

    public void exitTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext ctx) {
    }

    public void enterFieldAccess(FieldAccessContext ctx) {
    }

    public void exitFieldAccess(FieldAccessContext ctx) {
    }

    public void enterFieldAccess_lf_primary(FieldAccess_lf_primaryContext ctx) {
    }

    public void exitFieldAccess_lf_primary(FieldAccess_lf_primaryContext ctx) {
    }

    public void enterFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext ctx) {
    }

    public void exitFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext ctx) {
    }

    public void enterArrayAccess(ArrayAccessContext ctx) {
    }

    public void exitArrayAccess(ArrayAccessContext ctx) {
    }

    public void enterArrayAccess_lf_primary(ArrayAccess_lf_primaryContext ctx) {
    }

    public void exitArrayAccess_lf_primary(ArrayAccess_lf_primaryContext ctx) {
    }

    public void enterArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext ctx) {
    }

    public void exitArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext ctx) {
    }

    public void enterMethodInvocation(MethodInvocationContext ctx) {
    }

    public void exitMethodInvocation(MethodInvocationContext ctx) {
    }

    public void enterMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext ctx) {
    }

    public void exitMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext ctx) {
    }

    public void enterMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext ctx) {
    }

    public void exitMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext ctx) {
    }

    public void enterArgumentList(ArgumentListContext ctx) {
    }

    public void exitArgumentList(ArgumentListContext ctx) {
    }

    public void enterMethodReference(MethodReferenceContext ctx) {
    }

    public void exitMethodReference(MethodReferenceContext ctx) {
    }

    public void enterMethodReference_lf_primary(MethodReference_lf_primaryContext ctx) {
    }

    public void exitMethodReference_lf_primary(MethodReference_lf_primaryContext ctx) {
    }

    public void enterMethodReference_lfno_primary(MethodReference_lfno_primaryContext ctx) {
    }

    public void exitMethodReference_lfno_primary(MethodReference_lfno_primaryContext ctx) {
    }

    public void enterArrayCreationExpression(ArrayCreationExpressionContext ctx) {
    }

    public void exitArrayCreationExpression(ArrayCreationExpressionContext ctx) {
    }

    public void enterDimExprs(DimExprsContext ctx) {
    }

    public void exitDimExprs(DimExprsContext ctx) {
    }

    public void enterDimExpr(DimExprContext ctx) {
    }

    public void exitDimExpr(DimExprContext ctx) {
    }

    public void enterConstantExpression(ConstantExpressionContext ctx) {
    }

    public void exitConstantExpression(ConstantExpressionContext ctx) {
    }

    public void enterExpression(ExpressionContext ctx) {
    }

    public void exitExpression(ExpressionContext ctx) {
    }

    public void enterLambdaExpression(LambdaExpressionContext ctx) {
    }

    public void exitLambdaExpression(LambdaExpressionContext ctx) {
    }

    public void enterLambdaParameters(LambdaParametersContext ctx) {
    }

    public void exitLambdaParameters(LambdaParametersContext ctx) {
    }

    public void enterInferredFormalParameterList(InferredFormalParameterListContext ctx) {
    }

    public void exitInferredFormalParameterList(InferredFormalParameterListContext ctx) {
    }

    public void enterLambdaBody(LambdaBodyContext ctx) {
    }

    public void exitLambdaBody(LambdaBodyContext ctx) {
    }

    public void enterAssignmentExpression(AssignmentExpressionContext ctx) {
    }

    public void exitAssignmentExpression(AssignmentExpressionContext ctx) {
    }

    public void enterAssignment(AssignmentContext ctx) {
    }

    public void exitAssignment(AssignmentContext ctx) {
    }

    public void enterLeftHandSide(LeftHandSideContext ctx) {
    }

    public void exitLeftHandSide(LeftHandSideContext ctx) {
    }

    public void enterAssignmentOperator(AssignmentOperatorContext ctx) {
    }

    public void exitAssignmentOperator(AssignmentOperatorContext ctx) {
    }

    public void enterConditionalExpression(ConditionalExpressionContext ctx) {
    }

    public void exitConditionalExpression(ConditionalExpressionContext ctx) {
    }

    public void enterConditionalOrExpression(ConditionalOrExpressionContext ctx) {
    }

    public void exitConditionalOrExpression(ConditionalOrExpressionContext ctx) {
    }

    public void enterConditionalAndExpression(ConditionalAndExpressionContext ctx) {
    }

    public void exitConditionalAndExpression(ConditionalAndExpressionContext ctx) {
    }

    public void enterInclusiveOrExpression(InclusiveOrExpressionContext ctx) {
    }

    public void exitInclusiveOrExpression(InclusiveOrExpressionContext ctx) {
    }

    public void enterExclusiveOrExpression(ExclusiveOrExpressionContext ctx) {
    }

    public void exitExclusiveOrExpression(ExclusiveOrExpressionContext ctx) {
    }

    public void enterAndExpression(AndExpressionContext ctx) {
    }

    public void exitAndExpression(AndExpressionContext ctx) {
    }

    public void enterEqualityExpression(EqualityExpressionContext ctx) {
    }

    public void exitEqualityExpression(EqualityExpressionContext ctx) {
    }

    public void enterRelationalExpression(RelationalExpressionContext ctx) {
    }

    public void exitRelationalExpression(RelationalExpressionContext ctx) {
    }

    public void enterShiftExpression(ShiftExpressionContext ctx) {
    }

    public void exitShiftExpression(ShiftExpressionContext ctx) {
    }

    public void enterAdditiveExpression(AdditiveExpressionContext ctx) {
    }

    public void exitAdditiveExpression(AdditiveExpressionContext ctx) {
    }

    public void enterMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
    }

    public void exitMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
    }

    public void enterUnaryExpression(UnaryExpressionContext ctx) {
    }

    public void exitUnaryExpression(UnaryExpressionContext ctx) {
    }

    public void enterPreIncrementExpression(PreIncrementExpressionContext ctx) {
    }

    public void exitPreIncrementExpression(PreIncrementExpressionContext ctx) {
    }

    public void enterPreDecrementExpression(PreDecrementExpressionContext ctx) {
    }

    public void exitPreDecrementExpression(PreDecrementExpressionContext ctx) {
    }

    public void enterUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext ctx) {
    }

    public void exitUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext ctx) {
    }

    public void enterPostfixExpression(PostfixExpressionContext ctx) {
    }

    public void exitPostfixExpression(PostfixExpressionContext ctx) {
    }

    public void enterPostIncrementExpression(PostIncrementExpressionContext ctx) {
    }

    public void exitPostIncrementExpression(PostIncrementExpressionContext ctx) {
    }

    public void enterPostIncrementExpression_lf_postfixExpression(PostIncrementExpression_lf_postfixExpressionContext ctx) {
    }

    public void exitPostIncrementExpression_lf_postfixExpression(PostIncrementExpression_lf_postfixExpressionContext ctx) {
    }

    public void enterPostDecrementExpression(PostDecrementExpressionContext ctx) {
    }

    public void exitPostDecrementExpression(PostDecrementExpressionContext ctx) {
    }

    public void enterPostDecrementExpression_lf_postfixExpression(PostDecrementExpression_lf_postfixExpressionContext ctx) {
    }

    public void exitPostDecrementExpression_lf_postfixExpression(PostDecrementExpression_lf_postfixExpressionContext ctx) {
    }

    public void enterCastExpression(CastExpressionContext ctx) {
    }

    public void exitCastExpression(CastExpressionContext ctx) {
    }

    public void enterEveryRule(ParserRuleContext ctx) {
    }

    public void exitEveryRule(ParserRuleContext ctx) {
    }

    public void visitTerminal(TerminalNode node) {
    }

    public void visitErrorNode(ErrorNode node) {
    }
}
