package metrics;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import metrics.Java8Parser.*;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface Java8Listener extends ParseTreeListener {
    void enterLiteral(LiteralContext var1);

    void exitLiteral(LiteralContext var1);

    void enterType(TypeContext var1);

    void exitType(TypeContext var1);

    void enterPrimitiveType(PrimitiveTypeContext var1);

    void exitPrimitiveType(PrimitiveTypeContext var1);

    void enterNumericType(NumericTypeContext var1);

    void exitNumericType(NumericTypeContext var1);

    void enterIntegralType(IntegralTypeContext var1);

    void exitIntegralType(IntegralTypeContext var1);

    void enterFloatingPointType(FloatingPointTypeContext var1);

    void exitFloatingPointType(FloatingPointTypeContext var1);

    void enterReferenceType(ReferenceTypeContext var1);

    void exitReferenceType(ReferenceTypeContext var1);

    void enterClassOrInterfaceType(ClassOrInterfaceTypeContext var1);

    void exitClassOrInterfaceType(ClassOrInterfaceTypeContext var1);

    void enterClassType(ClassTypeContext var1);

    void exitClassType(ClassTypeContext var1);

    void enterClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext var1);

    void exitClassType_lf_classOrInterfaceType(ClassType_lf_classOrInterfaceTypeContext var1);

    void enterClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext var1);

    void exitClassType_lfno_classOrInterfaceType(ClassType_lfno_classOrInterfaceTypeContext var1);

    void enterInterfaceType(InterfaceTypeContext var1);

    void exitInterfaceType(InterfaceTypeContext var1);

    void enterInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext var1);

    void exitInterfaceType_lf_classOrInterfaceType(InterfaceType_lf_classOrInterfaceTypeContext var1);

    void enterInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext var1);

    void exitInterfaceType_lfno_classOrInterfaceType(InterfaceType_lfno_classOrInterfaceTypeContext var1);

    void enterTypeVariable(TypeVariableContext var1);

    void exitTypeVariable(TypeVariableContext var1);

    void enterArrayType(ArrayTypeContext var1);

    void exitArrayType(ArrayTypeContext var1);

    void enterDims(DimsContext var1);

    void exitDims(DimsContext var1);

    void enterTypeParameter(TypeParameterContext var1);

    void exitTypeParameter(TypeParameterContext var1);

    void enterTypeParameterModifier(TypeParameterModifierContext var1);

    void exitTypeParameterModifier(TypeParameterModifierContext var1);

    void enterTypeBound(TypeBoundContext var1);

    void exitTypeBound(TypeBoundContext var1);

    void enterAdditionalBound(AdditionalBoundContext var1);

    void exitAdditionalBound(AdditionalBoundContext var1);

    void enterTypeArguments(TypeArgumentsContext var1);

    void exitTypeArguments(TypeArgumentsContext var1);

    void enterTypeArgumentList(TypeArgumentListContext var1);

    void exitTypeArgumentList(TypeArgumentListContext var1);

    void enterTypeArgument(TypeArgumentContext var1);

    void exitTypeArgument(TypeArgumentContext var1);

    void enterWildcard(WildcardContext var1);

    void exitWildcard(WildcardContext var1);

    void enterWildcardBounds(WildcardBoundsContext var1);

    void exitWildcardBounds(WildcardBoundsContext var1);

    void enterPackageName(PackageNameContext var1);

    void exitPackageName(PackageNameContext var1);

    void enterTypeName(TypeNameContext var1);

    void exitTypeName(TypeNameContext var1);

    void enterPackageOrTypeName(PackageOrTypeNameContext var1);

    void exitPackageOrTypeName(PackageOrTypeNameContext var1);

    void enterExpressionName(ExpressionNameContext var1);

    void exitExpressionName(ExpressionNameContext var1);

    void enterMethodName(MethodNameContext var1);

    void exitMethodName(MethodNameContext var1);

    void enterAmbiguousName(AmbiguousNameContext var1);

    void exitAmbiguousName(AmbiguousNameContext var1);

    void enterCompilationUnit(CompilationUnitContext var1);

    void exitCompilationUnit(CompilationUnitContext var1);

    void enterPackageDeclaration(PackageDeclarationContext var1);

    void exitPackageDeclaration(PackageDeclarationContext var1);

    void enterPackageModifier(PackageModifierContext var1);

    void exitPackageModifier(PackageModifierContext var1);

    void enterImportDeclaration(ImportDeclarationContext var1);

    void exitImportDeclaration(ImportDeclarationContext var1);

    void enterSingleTypeImportDeclaration(SingleTypeImportDeclarationContext var1);

    void exitSingleTypeImportDeclaration(SingleTypeImportDeclarationContext var1);

    void enterTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext var1);

    void exitTypeImportOnDemandDeclaration(TypeImportOnDemandDeclarationContext var1);

    void enterSingleStaticImportDeclaration(SingleStaticImportDeclarationContext var1);

    void exitSingleStaticImportDeclaration(SingleStaticImportDeclarationContext var1);

    void enterStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext var1);

    void exitStaticImportOnDemandDeclaration(StaticImportOnDemandDeclarationContext var1);

    void enterTypeDeclaration(TypeDeclarationContext var1);

    void exitTypeDeclaration(TypeDeclarationContext var1);

    void enterClassDeclaration(ClassDeclarationContext var1);

    void exitClassDeclaration(ClassDeclarationContext var1);

    void enterNormalClassDeclaration(NormalClassDeclarationContext var1);

    void exitNormalClassDeclaration(NormalClassDeclarationContext var1);

    void enterClassModifier(ClassModifierContext var1);

    void exitClassModifier(ClassModifierContext var1);

    void enterTypeParameters(TypeParametersContext var1);

    void exitTypeParameters(TypeParametersContext var1);

    void enterTypeParameterList(TypeParameterListContext var1);

    void exitTypeParameterList(TypeParameterListContext var1);

    void enterSuperclass(SuperclassContext var1);

    void exitSuperclass(SuperclassContext var1);

    void enterSuperinterfaces(SuperinterfacesContext var1);

    void exitSuperinterfaces(SuperinterfacesContext var1);

    void enterInterfaceTypeList(InterfaceTypeListContext var1);

    void exitInterfaceTypeList(InterfaceTypeListContext var1);

    void enterClassBody(ClassBodyContext var1);

    void exitClassBody(ClassBodyContext var1);

    void enterClassBodyDeclaration(ClassBodyDeclarationContext var1);

    void exitClassBodyDeclaration(ClassBodyDeclarationContext var1);

    void enterClassMemberDeclaration(ClassMemberDeclarationContext var1);

    void exitClassMemberDeclaration(ClassMemberDeclarationContext var1);

    void enterFieldDeclaration(FieldDeclarationContext var1);

    void exitFieldDeclaration(FieldDeclarationContext var1);

    void enterFieldModifier(FieldModifierContext var1);

    void exitFieldModifier(FieldModifierContext var1);

    void enterVariableDeclaratorList(VariableDeclaratorListContext var1);

    void exitVariableDeclaratorList(VariableDeclaratorListContext var1);

    void enterVariableDeclarator(VariableDeclaratorContext var1);

    void exitVariableDeclarator(VariableDeclaratorContext var1);

    void enterVariableDeclaratorId(VariableDeclaratorIdContext var1);

    void exitVariableDeclaratorId(VariableDeclaratorIdContext var1);

    void enterVariableInitializer(VariableInitializerContext var1);

    void exitVariableInitializer(VariableInitializerContext var1);

    void enterUnannType(UnannTypeContext var1);

    void exitUnannType(UnannTypeContext var1);

    void enterUnannPrimitiveType(UnannPrimitiveTypeContext var1);

    void exitUnannPrimitiveType(UnannPrimitiveTypeContext var1);

    void enterUnannReferenceType(UnannReferenceTypeContext var1);

    void exitUnannReferenceType(UnannReferenceTypeContext var1);

    void enterUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext var1);

    void exitUnannClassOrInterfaceType(UnannClassOrInterfaceTypeContext var1);

    void enterUnannClassType(UnannClassTypeContext var1);

    void exitUnannClassType(UnannClassTypeContext var1);

    void enterUnannClassType_lf_unannClassOrInterfaceType(UnannClassType_lf_unannClassOrInterfaceTypeContext var1);

    void exitUnannClassType_lf_unannClassOrInterfaceType(UnannClassType_lf_unannClassOrInterfaceTypeContext var1);

    void enterUnannClassType_lfno_unannClassOrInterfaceType(UnannClassType_lfno_unannClassOrInterfaceTypeContext var1);

    void exitUnannClassType_lfno_unannClassOrInterfaceType(UnannClassType_lfno_unannClassOrInterfaceTypeContext var1);

    void enterUnannInterfaceType(UnannInterfaceTypeContext var1);

    void exitUnannInterfaceType(UnannInterfaceTypeContext var1);

    void enterUnannInterfaceType_lf_unannClassOrInterfaceType(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext var1);

    void exitUnannInterfaceType_lf_unannClassOrInterfaceType(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext var1);

    void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext var1);

    void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext var1);

    void enterUnannTypeVariable(UnannTypeVariableContext var1);

    void exitUnannTypeVariable(UnannTypeVariableContext var1);

    void enterUnannArrayType(UnannArrayTypeContext var1);

    void exitUnannArrayType(UnannArrayTypeContext var1);

    void enterMethodDeclaration(MethodDeclarationContext var1);

    void exitMethodDeclaration(MethodDeclarationContext var1);

    void enterMethodModifier(MethodModifierContext var1);

    void exitMethodModifier(MethodModifierContext var1);

    void enterMethodHeader(MethodHeaderContext var1);

    void exitMethodHeader(MethodHeaderContext var1);

    void enterResult(ResultContext var1);

    void exitResult(ResultContext var1);

    void enterMethodDeclarator(MethodDeclaratorContext var1);

    void exitMethodDeclarator(MethodDeclaratorContext var1);

    void enterFormalParameterList(FormalParameterListContext var1);

    void exitFormalParameterList(FormalParameterListContext var1);

    void enterFormalParameters(FormalParametersContext var1);

    void exitFormalParameters(FormalParametersContext var1);

    void enterFormalParameter(FormalParameterContext var1);

    void exitFormalParameter(FormalParameterContext var1);

    void enterVariableModifier(VariableModifierContext var1);

    void exitVariableModifier(VariableModifierContext var1);

    void enterLastFormalParameter(LastFormalParameterContext var1);

    void exitLastFormalParameter(LastFormalParameterContext var1);

    void enterReceiverParameter(ReceiverParameterContext var1);

    void exitReceiverParameter(ReceiverParameterContext var1);

    void enterThrows_(Throws_Context var1);

    void exitThrows_(Throws_Context var1);

    void enterExceptionTypeList(ExceptionTypeListContext var1);

    void exitExceptionTypeList(ExceptionTypeListContext var1);

    void enterExceptionType(ExceptionTypeContext var1);

    void exitExceptionType(ExceptionTypeContext var1);

    void enterMethodBody(MethodBodyContext var1);

    void exitMethodBody(MethodBodyContext var1);

    void enterInstanceInitializer(InstanceInitializerContext var1);

    void exitInstanceInitializer(InstanceInitializerContext var1);

    void enterStaticInitializer(StaticInitializerContext var1);

    void exitStaticInitializer(StaticInitializerContext var1);

    void enterConstructorDeclaration(ConstructorDeclarationContext var1);

    void exitConstructorDeclaration(ConstructorDeclarationContext var1);

    void enterConstructorModifier(ConstructorModifierContext var1);

    void exitConstructorModifier(ConstructorModifierContext var1);

    void enterConstructorDeclarator(ConstructorDeclaratorContext var1);

    void exitConstructorDeclarator(ConstructorDeclaratorContext var1);

    void enterSimpleTypeName(SimpleTypeNameContext var1);

    void exitSimpleTypeName(SimpleTypeNameContext var1);

    void enterConstructorBody(ConstructorBodyContext var1);

    void exitConstructorBody(ConstructorBodyContext var1);

    void enterExplicitConstructorInvocation(ExplicitConstructorInvocationContext var1);

    void exitExplicitConstructorInvocation(ExplicitConstructorInvocationContext var1);

    void enterEnumDeclaration(EnumDeclarationContext var1);

    void exitEnumDeclaration(EnumDeclarationContext var1);

    void enterEnumBody(EnumBodyContext var1);

    void exitEnumBody(EnumBodyContext var1);

    void enterEnumConstantList(EnumConstantListContext var1);

    void exitEnumConstantList(EnumConstantListContext var1);

    void enterEnumConstant(EnumConstantContext var1);

    void exitEnumConstant(EnumConstantContext var1);

    void enterEnumConstantModifier(EnumConstantModifierContext var1);

    void exitEnumConstantModifier(EnumConstantModifierContext var1);

    void enterEnumBodyDeclarations(EnumBodyDeclarationsContext var1);

    void exitEnumBodyDeclarations(EnumBodyDeclarationsContext var1);

    void enterInterfaceDeclaration(InterfaceDeclarationContext var1);

    void exitInterfaceDeclaration(InterfaceDeclarationContext var1);

    void enterNormalInterfaceDeclaration(NormalInterfaceDeclarationContext var1);

    void exitNormalInterfaceDeclaration(NormalInterfaceDeclarationContext var1);

    void enterInterfaceModifier(InterfaceModifierContext var1);

    void exitInterfaceModifier(InterfaceModifierContext var1);

    void enterExtendsInterfaces(ExtendsInterfacesContext var1);

    void exitExtendsInterfaces(ExtendsInterfacesContext var1);

    void enterInterfaceBody(InterfaceBodyContext var1);

    void exitInterfaceBody(InterfaceBodyContext var1);

    void enterInterfaceMemberDeclaration(InterfaceMemberDeclarationContext var1);

    void exitInterfaceMemberDeclaration(InterfaceMemberDeclarationContext var1);

    void enterConstantDeclaration(ConstantDeclarationContext var1);

    void exitConstantDeclaration(ConstantDeclarationContext var1);

    void enterConstantModifier(ConstantModifierContext var1);

    void exitConstantModifier(ConstantModifierContext var1);

    void enterInterfaceMethodDeclaration(InterfaceMethodDeclarationContext var1);

    void exitInterfaceMethodDeclaration(InterfaceMethodDeclarationContext var1);

    void enterInterfaceMethodModifier(InterfaceMethodModifierContext var1);

    void exitInterfaceMethodModifier(InterfaceMethodModifierContext var1);

    void enterAnnotationTypeDeclaration(AnnotationTypeDeclarationContext var1);

    void exitAnnotationTypeDeclaration(AnnotationTypeDeclarationContext var1);

    void enterAnnotationTypeBody(AnnotationTypeBodyContext var1);

    void exitAnnotationTypeBody(AnnotationTypeBodyContext var1);

    void enterAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext var1);

    void exitAnnotationTypeMemberDeclaration(AnnotationTypeMemberDeclarationContext var1);

    void enterAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext var1);

    void exitAnnotationTypeElementDeclaration(AnnotationTypeElementDeclarationContext var1);

    void enterAnnotationTypeElementModifier(AnnotationTypeElementModifierContext var1);

    void exitAnnotationTypeElementModifier(AnnotationTypeElementModifierContext var1);

    void enterDefaultValue(DefaultValueContext var1);

    void exitDefaultValue(DefaultValueContext var1);

    void enterAnnotation(AnnotationContext var1);

    void exitAnnotation(AnnotationContext var1);

    void enterNormalAnnotation(NormalAnnotationContext var1);

    void exitNormalAnnotation(NormalAnnotationContext var1);

    void enterElementValuePairList(ElementValuePairListContext var1);

    void exitElementValuePairList(ElementValuePairListContext var1);

    void enterElementValuePair(ElementValuePairContext var1);

    void exitElementValuePair(ElementValuePairContext var1);

    void enterElementValue(ElementValueContext var1);

    void exitElementValue(ElementValueContext var1);

    void enterElementValueArrayInitializer(ElementValueArrayInitializerContext var1);

    void exitElementValueArrayInitializer(ElementValueArrayInitializerContext var1);

    void enterElementValueList(ElementValueListContext var1);

    void exitElementValueList(ElementValueListContext var1);

    void enterMarkerAnnotation(MarkerAnnotationContext var1);

    void exitMarkerAnnotation(MarkerAnnotationContext var1);

    void enterSingleElementAnnotation(SingleElementAnnotationContext var1);

    void exitSingleElementAnnotation(SingleElementAnnotationContext var1);

    void enterArrayInitializer(ArrayInitializerContext var1);

    void exitArrayInitializer(ArrayInitializerContext var1);

    void enterVariableInitializerList(VariableInitializerListContext var1);

    void exitVariableInitializerList(VariableInitializerListContext var1);

    void enterBlock(BlockContext var1);

    void exitBlock(BlockContext var1);

    void enterBlockStatements(BlockStatementsContext var1);

    void exitBlockStatements(BlockStatementsContext var1);

    void enterBlockStatement(BlockStatementContext var1);

    void exitBlockStatement(BlockStatementContext var1);

    void enterLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext var1);

    void exitLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext var1);

    void enterLocalVariableDeclaration(LocalVariableDeclarationContext var1);

    void exitLocalVariableDeclaration(LocalVariableDeclarationContext var1);

    void enterStatement(StatementContext var1);

    void exitStatement(StatementContext var1);

    void enterStatementNoShortIf(StatementNoShortIfContext var1);

    void exitStatementNoShortIf(StatementNoShortIfContext var1);

    void enterStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext var1);

    void exitStatementWithoutTrailingSubstatement(StatementWithoutTrailingSubstatementContext var1);

    void enterEmptyStatement(EmptyStatementContext var1);

    void exitEmptyStatement(EmptyStatementContext var1);

    void enterLabeledStatement(LabeledStatementContext var1);

    void exitLabeledStatement(LabeledStatementContext var1);

    void enterLabeledStatementNoShortIf(LabeledStatementNoShortIfContext var1);

    void exitLabeledStatementNoShortIf(LabeledStatementNoShortIfContext var1);

    void enterExpressionStatement(ExpressionStatementContext var1);

    void exitExpressionStatement(ExpressionStatementContext var1);

    void enterStatementExpression(StatementExpressionContext var1);

    void exitStatementExpression(StatementExpressionContext var1);

    void enterIfThenStatement(IfThenStatementContext var1);

    void exitIfThenStatement(IfThenStatementContext var1);

    void enterIfThenElseStatement(IfThenElseStatementContext var1);

    void exitIfThenElseStatement(IfThenElseStatementContext var1);

    void enterIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext var1);

    void exitIfThenElseStatementNoShortIf(IfThenElseStatementNoShortIfContext var1);

    void enterAssertStatement(AssertStatementContext var1);

    void exitAssertStatement(AssertStatementContext var1);

    void enterSwitchStatement(SwitchStatementContext var1);

    void exitSwitchStatement(SwitchStatementContext var1);

    void enterSwitchBlock(SwitchBlockContext var1);

    void exitSwitchBlock(SwitchBlockContext var1);

    void enterSwitchBlockStatementGroup(SwitchBlockStatementGroupContext var1);

    void exitSwitchBlockStatementGroup(SwitchBlockStatementGroupContext var1);

    void enterSwitchLabels(SwitchLabelsContext var1);

    void exitSwitchLabels(SwitchLabelsContext var1);

    void enterSwitchLabel(SwitchLabelContext var1);

    void exitSwitchLabel(SwitchLabelContext var1);

    void enterEnumConstantName(EnumConstantNameContext var1);

    void exitEnumConstantName(EnumConstantNameContext var1);

    void enterWhileStatement(WhileStatementContext var1);

    void exitWhileStatement(WhileStatementContext var1);

    void enterWhileStatementNoShortIf(WhileStatementNoShortIfContext var1);

    void exitWhileStatementNoShortIf(WhileStatementNoShortIfContext var1);

    void enterDoStatement(DoStatementContext var1);

    void exitDoStatement(DoStatementContext var1);

    void enterForStatement(ForStatementContext var1);

    void exitForStatement(ForStatementContext var1);

    void enterForStatementNoShortIf(ForStatementNoShortIfContext var1);

    void exitForStatementNoShortIf(ForStatementNoShortIfContext var1);

    void enterBasicForStatement(BasicForStatementContext var1);

    void exitBasicForStatement(BasicForStatementContext var1);

    void enterBasicForStatementNoShortIf(BasicForStatementNoShortIfContext var1);

    void exitBasicForStatementNoShortIf(BasicForStatementNoShortIfContext var1);

    void enterForInit(ForInitContext var1);

    void exitForInit(ForInitContext var1);

    void enterForUpdate(ForUpdateContext var1);

    void exitForUpdate(ForUpdateContext var1);

    void enterStatementExpressionList(StatementExpressionListContext var1);

    void exitStatementExpressionList(StatementExpressionListContext var1);

    void enterEnhancedForStatement(EnhancedForStatementContext var1);

    void exitEnhancedForStatement(EnhancedForStatementContext var1);

    void enterEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext var1);

    void exitEnhancedForStatementNoShortIf(EnhancedForStatementNoShortIfContext var1);

    void enterBreakStatement(BreakStatementContext var1);

    void exitBreakStatement(BreakStatementContext var1);

    void enterContinueStatement(ContinueStatementContext var1);

    void exitContinueStatement(ContinueStatementContext var1);

    void enterReturnStatement(ReturnStatementContext var1);

    void exitReturnStatement(ReturnStatementContext var1);

    void enterThrowStatement(ThrowStatementContext var1);

    void exitThrowStatement(ThrowStatementContext var1);

    void enterSynchronizedStatement(SynchronizedStatementContext var1);

    void exitSynchronizedStatement(SynchronizedStatementContext var1);

    void enterTryStatement(TryStatementContext var1);

    void exitTryStatement(TryStatementContext var1);

    void enterCatches(CatchesContext var1);

    void exitCatches(CatchesContext var1);

    void enterCatchClause(CatchClauseContext var1);

    void exitCatchClause(CatchClauseContext var1);

    void enterCatchFormalParameter(CatchFormalParameterContext var1);

    void exitCatchFormalParameter(CatchFormalParameterContext var1);

    void enterCatchType(CatchTypeContext var1);

    void exitCatchType(CatchTypeContext var1);

    void enterFinally_(Finally_Context var1);

    void exitFinally_(Finally_Context var1);

    void enterTryWithResourcesStatement(TryWithResourcesStatementContext var1);

    void exitTryWithResourcesStatement(TryWithResourcesStatementContext var1);

    void enterResourceSpecification(ResourceSpecificationContext var1);

    void exitResourceSpecification(ResourceSpecificationContext var1);

    void enterResourceList(ResourceListContext var1);

    void exitResourceList(ResourceListContext var1);

    void enterResource(ResourceContext var1);

    void exitResource(ResourceContext var1);

    void enterPrimary(PrimaryContext var1);

    void exitPrimary(PrimaryContext var1);

    void enterPrimaryNoNewArray(PrimaryNoNewArrayContext var1);

    void exitPrimaryNoNewArray(PrimaryNoNewArrayContext var1);

    void enterPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext var1);

    void exitPrimaryNoNewArray_lf_arrayAccess(PrimaryNoNewArray_lf_arrayAccessContext var1);

    void enterPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext var1);

    void exitPrimaryNoNewArray_lfno_arrayAccess(PrimaryNoNewArray_lfno_arrayAccessContext var1);

    void enterPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary(PrimaryNoNewArray_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary(PrimaryNoNewArray_lfno_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext var1);

    void enterClassInstanceCreationExpression(ClassInstanceCreationExpressionContext var1);

    void exitClassInstanceCreationExpression(ClassInstanceCreationExpressionContext var1);

    void enterClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext var1);

    void exitClassInstanceCreationExpression_lf_primary(ClassInstanceCreationExpression_lf_primaryContext var1);

    void enterClassInstanceCreationExpression_lfno_primary(ClassInstanceCreationExpression_lfno_primaryContext var1);

    void exitClassInstanceCreationExpression_lfno_primary(ClassInstanceCreationExpression_lfno_primaryContext var1);

    void enterTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext var1);

    void exitTypeArgumentsOrDiamond(TypeArgumentsOrDiamondContext var1);

    void enterFieldAccess(FieldAccessContext var1);

    void exitFieldAccess(FieldAccessContext var1);

    void enterFieldAccess_lf_primary(FieldAccess_lf_primaryContext var1);

    void exitFieldAccess_lf_primary(FieldAccess_lf_primaryContext var1);

    void enterFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext var1);

    void exitFieldAccess_lfno_primary(FieldAccess_lfno_primaryContext var1);

    void enterArrayAccess(ArrayAccessContext var1);

    void exitArrayAccess(ArrayAccessContext var1);

    void enterArrayAccess_lf_primary(ArrayAccess_lf_primaryContext var1);

    void exitArrayAccess_lf_primary(ArrayAccess_lf_primaryContext var1);

    void enterArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext var1);

    void exitArrayAccess_lfno_primary(ArrayAccess_lfno_primaryContext var1);

    void enterMethodInvocation(MethodInvocationContext var1);

    void exitMethodInvocation(MethodInvocationContext var1);

    void enterMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext var1);

    void exitMethodInvocation_lf_primary(MethodInvocation_lf_primaryContext var1);

    void enterMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext var1);

    void exitMethodInvocation_lfno_primary(MethodInvocation_lfno_primaryContext var1);

    void enterArgumentList(ArgumentListContext var1);

    void exitArgumentList(ArgumentListContext var1);

    void enterMethodReference(MethodReferenceContext var1);

    void exitMethodReference(MethodReferenceContext var1);

    void enterMethodReference_lf_primary(MethodReference_lf_primaryContext var1);

    void exitMethodReference_lf_primary(MethodReference_lf_primaryContext var1);

    void enterMethodReference_lfno_primary(MethodReference_lfno_primaryContext var1);

    void exitMethodReference_lfno_primary(MethodReference_lfno_primaryContext var1);

    void enterArrayCreationExpression(ArrayCreationExpressionContext var1);

    void exitArrayCreationExpression(ArrayCreationExpressionContext var1);

    void enterDimExprs(DimExprsContext var1);

    void exitDimExprs(DimExprsContext var1);

    void enterDimExpr(DimExprContext var1);

    void exitDimExpr(DimExprContext var1);

    void enterConstantExpression(ConstantExpressionContext var1);

    void exitConstantExpression(ConstantExpressionContext var1);

    void enterExpression(ExpressionContext var1);

    void exitExpression(ExpressionContext var1);

    void enterLambdaExpression(LambdaExpressionContext var1);

    void exitLambdaExpression(LambdaExpressionContext var1);

    void enterLambdaParameters(LambdaParametersContext var1);

    void exitLambdaParameters(LambdaParametersContext var1);

    void enterInferredFormalParameterList(InferredFormalParameterListContext var1);

    void exitInferredFormalParameterList(InferredFormalParameterListContext var1);

    void enterLambdaBody(LambdaBodyContext var1);

    void exitLambdaBody(LambdaBodyContext var1);

    void enterAssignmentExpression(AssignmentExpressionContext var1);

    void exitAssignmentExpression(AssignmentExpressionContext var1);

    void enterAssignment(AssignmentContext var1);

    void exitAssignment(AssignmentContext var1);

    void enterLeftHandSide(LeftHandSideContext var1);

    void exitLeftHandSide(LeftHandSideContext var1);

    void enterAssignmentOperator(AssignmentOperatorContext var1);

    void exitAssignmentOperator(AssignmentOperatorContext var1);

    void enterConditionalExpression(ConditionalExpressionContext var1);

    void exitConditionalExpression(ConditionalExpressionContext var1);

    void enterConditionalOrExpression(ConditionalOrExpressionContext var1);

    void exitConditionalOrExpression(ConditionalOrExpressionContext var1);

    void enterConditionalAndExpression(ConditionalAndExpressionContext var1);

    void exitConditionalAndExpression(ConditionalAndExpressionContext var1);

    void enterInclusiveOrExpression(InclusiveOrExpressionContext var1);

    void exitInclusiveOrExpression(InclusiveOrExpressionContext var1);

    void enterExclusiveOrExpression(ExclusiveOrExpressionContext var1);

    void exitExclusiveOrExpression(ExclusiveOrExpressionContext var1);

    void enterAndExpression(AndExpressionContext var1);

    void exitAndExpression(AndExpressionContext var1);

    void enterEqualityExpression(EqualityExpressionContext var1);

    void exitEqualityExpression(EqualityExpressionContext var1);

    void enterRelationalExpression(RelationalExpressionContext var1);

    void exitRelationalExpression(RelationalExpressionContext var1);

    void enterShiftExpression(ShiftExpressionContext var1);

    void exitShiftExpression(ShiftExpressionContext var1);

    void enterAdditiveExpression(AdditiveExpressionContext var1);

    void exitAdditiveExpression(AdditiveExpressionContext var1);

    void enterMultiplicativeExpression(MultiplicativeExpressionContext var1);

    void exitMultiplicativeExpression(MultiplicativeExpressionContext var1);

    void enterUnaryExpression(UnaryExpressionContext var1);

    void exitUnaryExpression(UnaryExpressionContext var1);

    void enterPreIncrementExpression(PreIncrementExpressionContext var1);

    void exitPreIncrementExpression(PreIncrementExpressionContext var1);

    void enterPreDecrementExpression(PreDecrementExpressionContext var1);

    void exitPreDecrementExpression(PreDecrementExpressionContext var1);

    void enterUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext var1);

    void exitUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinusContext var1);

    void enterPostfixExpression(PostfixExpressionContext var1);

    void exitPostfixExpression(PostfixExpressionContext var1);

    void enterPostIncrementExpression(PostIncrementExpressionContext var1);

    void exitPostIncrementExpression(PostIncrementExpressionContext var1);

    void enterPostIncrementExpression_lf_postfixExpression(PostIncrementExpression_lf_postfixExpressionContext var1);

    void exitPostIncrementExpression_lf_postfixExpression(PostIncrementExpression_lf_postfixExpressionContext var1);

    void enterPostDecrementExpression(PostDecrementExpressionContext var1);

    void exitPostDecrementExpression(PostDecrementExpressionContext var1);

    void enterPostDecrementExpression_lf_postfixExpression(PostDecrementExpression_lf_postfixExpressionContext var1);

    void exitPostDecrementExpression_lf_postfixExpression(PostDecrementExpression_lf_postfixExpressionContext var1);

    void enterCastExpression(CastExpressionContext var1);

    void exitCastExpression(CastExpressionContext var1);
}

