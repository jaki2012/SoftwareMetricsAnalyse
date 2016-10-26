package metrics.java;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface Java8Listener extends ParseTreeListener {
    void enterLiteral(Java8Parser.LiteralContext var1);

    void exitLiteral(Java8Parser.LiteralContext var1);

    void enterType(Java8Parser.TypeContext var1);

    void exitType(Java8Parser.TypeContext var1);

    void enterPrimitiveType(Java8Parser.PrimitiveTypeContext var1);

    void exitPrimitiveType(Java8Parser.PrimitiveTypeContext var1);

    void enterNumericType(Java8Parser.NumericTypeContext var1);

    void exitNumericType(Java8Parser.NumericTypeContext var1);

    void enterIntegralType(Java8Parser.IntegralTypeContext var1);

    void exitIntegralType(Java8Parser.IntegralTypeContext var1);

    void enterFloatingPointType(Java8Parser.FloatingPointTypeContext var1);

    void exitFloatingPointType(Java8Parser.FloatingPointTypeContext var1);

    void enterReferenceType(Java8Parser.ReferenceTypeContext var1);

    void exitReferenceType(Java8Parser.ReferenceTypeContext var1);

    void enterClassOrInterfaceType(Java8Parser.ClassOrInterfaceTypeContext var1);

    void exitClassOrInterfaceType(Java8Parser.ClassOrInterfaceTypeContext var1);

    void enterClassType(Java8Parser.ClassTypeContext var1);

    void exitClassType(Java8Parser.ClassTypeContext var1);

    void enterClassType_lf_classOrInterfaceType(Java8Parser.ClassType_lf_classOrInterfaceTypeContext var1);

    void exitClassType_lf_classOrInterfaceType(Java8Parser.ClassType_lf_classOrInterfaceTypeContext var1);

    void enterClassType_lfno_classOrInterfaceType(Java8Parser.ClassType_lfno_classOrInterfaceTypeContext var1);

    void exitClassType_lfno_classOrInterfaceType(Java8Parser.ClassType_lfno_classOrInterfaceTypeContext var1);

    void enterInterfaceType(Java8Parser.InterfaceTypeContext var1);

    void exitInterfaceType(Java8Parser.InterfaceTypeContext var1);

    void enterInterfaceType_lf_classOrInterfaceType(Java8Parser.InterfaceType_lf_classOrInterfaceTypeContext var1);

    void exitInterfaceType_lf_classOrInterfaceType(Java8Parser.InterfaceType_lf_classOrInterfaceTypeContext var1);

    void enterInterfaceType_lfno_classOrInterfaceType(Java8Parser.InterfaceType_lfno_classOrInterfaceTypeContext var1);

    void exitInterfaceType_lfno_classOrInterfaceType(Java8Parser.InterfaceType_lfno_classOrInterfaceTypeContext var1);

    void enterTypeVariable(Java8Parser.TypeVariableContext var1);

    void exitTypeVariable(Java8Parser.TypeVariableContext var1);

    void enterArrayType(Java8Parser.ArrayTypeContext var1);

    void exitArrayType(Java8Parser.ArrayTypeContext var1);

    void enterDims(Java8Parser.DimsContext var1);

    void exitDims(Java8Parser.DimsContext var1);

    void enterTypeParameter(Java8Parser.TypeParameterContext var1);

    void exitTypeParameter(Java8Parser.TypeParameterContext var1);

    void enterTypeParameterModifier(Java8Parser.TypeParameterModifierContext var1);

    void exitTypeParameterModifier(Java8Parser.TypeParameterModifierContext var1);

    void enterTypeBound(Java8Parser.TypeBoundContext var1);

    void exitTypeBound(Java8Parser.TypeBoundContext var1);

    void enterAdditionalBound(Java8Parser.AdditionalBoundContext var1);

    void exitAdditionalBound(Java8Parser.AdditionalBoundContext var1);

    void enterTypeArguments(Java8Parser.TypeArgumentsContext var1);

    void exitTypeArguments(Java8Parser.TypeArgumentsContext var1);

    void enterTypeArgumentList(Java8Parser.TypeArgumentListContext var1);

    void exitTypeArgumentList(Java8Parser.TypeArgumentListContext var1);

    void enterTypeArgument(Java8Parser.TypeArgumentContext var1);

    void exitTypeArgument(Java8Parser.TypeArgumentContext var1);

    void enterWildcard(Java8Parser.WildcardContext var1);

    void exitWildcard(Java8Parser.WildcardContext var1);

    void enterWildcardBounds(Java8Parser.WildcardBoundsContext var1);

    void exitWildcardBounds(Java8Parser.WildcardBoundsContext var1);

    void enterPackageName(Java8Parser.PackageNameContext var1);

    void exitPackageName(Java8Parser.PackageNameContext var1);

    void enterTypeName(Java8Parser.TypeNameContext var1);

    void exitTypeName(Java8Parser.TypeNameContext var1);

    void enterPackageOrTypeName(Java8Parser.PackageOrTypeNameContext var1);

    void exitPackageOrTypeName(Java8Parser.PackageOrTypeNameContext var1);

    void enterExpressionName(Java8Parser.ExpressionNameContext var1);

    void exitExpressionName(Java8Parser.ExpressionNameContext var1);

    void enterMethodName(Java8Parser.MethodNameContext var1);

    void exitMethodName(Java8Parser.MethodNameContext var1);

    void enterAmbiguousName(Java8Parser.AmbiguousNameContext var1);

    void exitAmbiguousName(Java8Parser.AmbiguousNameContext var1);

    void enterCompilationUnit(Java8Parser.CompilationUnitContext var1);

    void exitCompilationUnit(Java8Parser.CompilationUnitContext var1);

    void enterPackageDeclaration(Java8Parser.PackageDeclarationContext var1);

    void exitPackageDeclaration(Java8Parser.PackageDeclarationContext var1);

    void enterPackageModifier(Java8Parser.PackageModifierContext var1);

    void exitPackageModifier(Java8Parser.PackageModifierContext var1);

    void enterImportDeclaration(Java8Parser.ImportDeclarationContext var1);

    void exitImportDeclaration(Java8Parser.ImportDeclarationContext var1);

    void enterSingleTypeImportDeclaration(Java8Parser.SingleTypeImportDeclarationContext var1);

    void exitSingleTypeImportDeclaration(Java8Parser.SingleTypeImportDeclarationContext var1);

    void enterTypeImportOnDemandDeclaration(Java8Parser.TypeImportOnDemandDeclarationContext var1);

    void exitTypeImportOnDemandDeclaration(Java8Parser.TypeImportOnDemandDeclarationContext var1);

    void enterSingleStaticImportDeclaration(Java8Parser.SingleStaticImportDeclarationContext var1);

    void exitSingleStaticImportDeclaration(Java8Parser.SingleStaticImportDeclarationContext var1);

    void enterStaticImportOnDemandDeclaration(Java8Parser.StaticImportOnDemandDeclarationContext var1);

    void exitStaticImportOnDemandDeclaration(Java8Parser.StaticImportOnDemandDeclarationContext var1);

    void enterTypeDeclaration(Java8Parser.TypeDeclarationContext var1);

    void exitTypeDeclaration(Java8Parser.TypeDeclarationContext var1);

    void enterClassDeclaration(Java8Parser.ClassDeclarationContext var1);

    void exitClassDeclaration(Java8Parser.ClassDeclarationContext var1);

    void enterNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext var1);

    void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext var1);

    void enterClassModifier(Java8Parser.ClassModifierContext var1);

    void exitClassModifier(Java8Parser.ClassModifierContext var1);

    void enterTypeParameters(Java8Parser.TypeParametersContext var1);

    void exitTypeParameters(Java8Parser.TypeParametersContext var1);

    void enterTypeParameterList(Java8Parser.TypeParameterListContext var1);

    void exitTypeParameterList(Java8Parser.TypeParameterListContext var1);

    void enterSuperclass(Java8Parser.SuperclassContext var1);

    void exitSuperclass(Java8Parser.SuperclassContext var1);

    void enterSuperinterfaces(Java8Parser.SuperinterfacesContext var1);

    void exitSuperinterfaces(Java8Parser.SuperinterfacesContext var1);

    void enterInterfaceTypeList(Java8Parser.InterfaceTypeListContext var1);

    void exitInterfaceTypeList(Java8Parser.InterfaceTypeListContext var1);

    void enterClassBody(Java8Parser.ClassBodyContext var1);

    void exitClassBody(Java8Parser.ClassBodyContext var1);

    void enterClassBodyDeclaration(Java8Parser.ClassBodyDeclarationContext var1);

    void exitClassBodyDeclaration(Java8Parser.ClassBodyDeclarationContext var1);

    void enterClassMemberDeclaration(Java8Parser.ClassMemberDeclarationContext var1);

    void exitClassMemberDeclaration(Java8Parser.ClassMemberDeclarationContext var1);

    void enterFieldDeclaration(Java8Parser.FieldDeclarationContext var1);

    void exitFieldDeclaration(Java8Parser.FieldDeclarationContext var1);

    void enterFieldModifier(Java8Parser.FieldModifierContext var1);

    void exitFieldModifier(Java8Parser.FieldModifierContext var1);

    void enterVariableDeclaratorList(Java8Parser.VariableDeclaratorListContext var1);

    void exitVariableDeclaratorList(Java8Parser.VariableDeclaratorListContext var1);

    void enterVariableDeclarator(Java8Parser.VariableDeclaratorContext var1);

    void exitVariableDeclarator(Java8Parser.VariableDeclaratorContext var1);

    void enterVariableDeclaratorId(Java8Parser.VariableDeclaratorIdContext var1);

    void exitVariableDeclaratorId(Java8Parser.VariableDeclaratorIdContext var1);

    void enterVariableInitializer(Java8Parser.VariableInitializerContext var1);

    void exitVariableInitializer(Java8Parser.VariableInitializerContext var1);

    void enterUnannType(Java8Parser.UnannTypeContext var1);

    void exitUnannType(Java8Parser.UnannTypeContext var1);

    void enterUnannPrimitiveType(Java8Parser.UnannPrimitiveTypeContext var1);

    void exitUnannPrimitiveType(Java8Parser.UnannPrimitiveTypeContext var1);

    void enterUnannReferenceType(Java8Parser.UnannReferenceTypeContext var1);

    void exitUnannReferenceType(Java8Parser.UnannReferenceTypeContext var1);

    void enterUnannClassOrInterfaceType(Java8Parser.UnannClassOrInterfaceTypeContext var1);

    void exitUnannClassOrInterfaceType(Java8Parser.UnannClassOrInterfaceTypeContext var1);

    void enterUnannClassType(Java8Parser.UnannClassTypeContext var1);

    void exitUnannClassType(Java8Parser.UnannClassTypeContext var1);

    void enterUnannClassType_lf_unannClassOrInterfaceType(Java8Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext var1);

    void exitUnannClassType_lf_unannClassOrInterfaceType(Java8Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext var1);

    void enterUnannClassType_lfno_unannClassOrInterfaceType(Java8Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext var1);

    void exitUnannClassType_lfno_unannClassOrInterfaceType(Java8Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext var1);

    void enterUnannInterfaceType(Java8Parser.UnannInterfaceTypeContext var1);

    void exitUnannInterfaceType(Java8Parser.UnannInterfaceTypeContext var1);

    void enterUnannInterfaceType_lf_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext var1);

    void exitUnannInterfaceType_lf_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext var1);

    void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext var1);

    void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext var1);

    void enterUnannTypeVariable(Java8Parser.UnannTypeVariableContext var1);

    void exitUnannTypeVariable(Java8Parser.UnannTypeVariableContext var1);

    void enterUnannArrayType(Java8Parser.UnannArrayTypeContext var1);

    void exitUnannArrayType(Java8Parser.UnannArrayTypeContext var1);

    void enterMethodDeclaration(Java8Parser.MethodDeclarationContext var1);

    void exitMethodDeclaration(Java8Parser.MethodDeclarationContext var1);

    void enterMethodModifier(Java8Parser.MethodModifierContext var1);

    void exitMethodModifier(Java8Parser.MethodModifierContext var1);

    void enterMethodHeader(Java8Parser.MethodHeaderContext var1);

    void exitMethodHeader(Java8Parser.MethodHeaderContext var1);

    void enterResult(Java8Parser.ResultContext var1);

    void exitResult(Java8Parser.ResultContext var1);

    void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext var1);

    void exitMethodDeclarator(Java8Parser.MethodDeclaratorContext var1);

    void enterFormalParameterList(Java8Parser.FormalParameterListContext var1);

    void exitFormalParameterList(Java8Parser.FormalParameterListContext var1);

    void enterFormalParameters(Java8Parser.FormalParametersContext var1);

    void exitFormalParameters(Java8Parser.FormalParametersContext var1);

    void enterFormalParameter(Java8Parser.FormalParameterContext var1);

    void exitFormalParameter(Java8Parser.FormalParameterContext var1);

    void enterVariableModifier(Java8Parser.VariableModifierContext var1);

    void exitVariableModifier(Java8Parser.VariableModifierContext var1);

    void enterLastFormalParameter(Java8Parser.LastFormalParameterContext var1);

    void exitLastFormalParameter(Java8Parser.LastFormalParameterContext var1);

    void enterReceiverParameter(Java8Parser.ReceiverParameterContext var1);

    void exitReceiverParameter(Java8Parser.ReceiverParameterContext var1);

    void enterThrows_(Java8Parser.Throws_Context var1);

    void exitThrows_(Java8Parser.Throws_Context var1);

    void enterExceptionTypeList(Java8Parser.ExceptionTypeListContext var1);

    void exitExceptionTypeList(Java8Parser.ExceptionTypeListContext var1);

    void enterExceptionType(Java8Parser.ExceptionTypeContext var1);

    void exitExceptionType(Java8Parser.ExceptionTypeContext var1);

    void enterMethodBody(Java8Parser.MethodBodyContext var1);

    void exitMethodBody(Java8Parser.MethodBodyContext var1);

    void enterInstanceInitializer(Java8Parser.InstanceInitializerContext var1);

    void exitInstanceInitializer(Java8Parser.InstanceInitializerContext var1);

    void enterStaticInitializer(Java8Parser.StaticInitializerContext var1);

    void exitStaticInitializer(Java8Parser.StaticInitializerContext var1);

    void enterConstructorDeclaration(Java8Parser.ConstructorDeclarationContext var1);

    void exitConstructorDeclaration(Java8Parser.ConstructorDeclarationContext var1);

    void enterConstructorModifier(Java8Parser.ConstructorModifierContext var1);

    void exitConstructorModifier(Java8Parser.ConstructorModifierContext var1);

    void enterConstructorDeclarator(Java8Parser.ConstructorDeclaratorContext var1);

    void exitConstructorDeclarator(Java8Parser.ConstructorDeclaratorContext var1);

    void enterSimpleTypeName(Java8Parser.SimpleTypeNameContext var1);

    void exitSimpleTypeName(Java8Parser.SimpleTypeNameContext var1);

    void enterConstructorBody(Java8Parser.ConstructorBodyContext var1);

    void exitConstructorBody(Java8Parser.ConstructorBodyContext var1);

    void enterExplicitConstructorInvocation(Java8Parser.ExplicitConstructorInvocationContext var1);

    void exitExplicitConstructorInvocation(Java8Parser.ExplicitConstructorInvocationContext var1);

    void enterEnumDeclaration(Java8Parser.EnumDeclarationContext var1);

    void exitEnumDeclaration(Java8Parser.EnumDeclarationContext var1);

    void enterEnumBody(Java8Parser.EnumBodyContext var1);

    void exitEnumBody(Java8Parser.EnumBodyContext var1);

    void enterEnumConstantList(Java8Parser.EnumConstantListContext var1);

    void exitEnumConstantList(Java8Parser.EnumConstantListContext var1);

    void enterEnumConstant(Java8Parser.EnumConstantContext var1);

    void exitEnumConstant(Java8Parser.EnumConstantContext var1);

    void enterEnumConstantModifier(Java8Parser.EnumConstantModifierContext var1);

    void exitEnumConstantModifier(Java8Parser.EnumConstantModifierContext var1);

    void enterEnumBodyDeclarations(Java8Parser.EnumBodyDeclarationsContext var1);

    void exitEnumBodyDeclarations(Java8Parser.EnumBodyDeclarationsContext var1);

    void enterInterfaceDeclaration(Java8Parser.InterfaceDeclarationContext var1);

    void exitInterfaceDeclaration(Java8Parser.InterfaceDeclarationContext var1);

    void enterNormalInterfaceDeclaration(Java8Parser.NormalInterfaceDeclarationContext var1);

    void exitNormalInterfaceDeclaration(Java8Parser.NormalInterfaceDeclarationContext var1);

    void enterInterfaceModifier(Java8Parser.InterfaceModifierContext var1);

    void exitInterfaceModifier(Java8Parser.InterfaceModifierContext var1);

    void enterExtendsInterfaces(Java8Parser.ExtendsInterfacesContext var1);

    void exitExtendsInterfaces(Java8Parser.ExtendsInterfacesContext var1);

    void enterInterfaceBody(Java8Parser.InterfaceBodyContext var1);

    void exitInterfaceBody(Java8Parser.InterfaceBodyContext var1);

    void enterInterfaceMemberDeclaration(Java8Parser.InterfaceMemberDeclarationContext var1);

    void exitInterfaceMemberDeclaration(Java8Parser.InterfaceMemberDeclarationContext var1);

    void enterConstantDeclaration(Java8Parser.ConstantDeclarationContext var1);

    void exitConstantDeclaration(Java8Parser.ConstantDeclarationContext var1);

    void enterConstantModifier(Java8Parser.ConstantModifierContext var1);

    void exitConstantModifier(Java8Parser.ConstantModifierContext var1);

    void enterInterfaceMethodDeclaration(Java8Parser.InterfaceMethodDeclarationContext var1);

    void exitInterfaceMethodDeclaration(Java8Parser.InterfaceMethodDeclarationContext var1);

    void enterInterfaceMethodModifier(Java8Parser.InterfaceMethodModifierContext var1);

    void exitInterfaceMethodModifier(Java8Parser.InterfaceMethodModifierContext var1);

    void enterAnnotationTypeDeclaration(Java8Parser.AnnotationTypeDeclarationContext var1);

    void exitAnnotationTypeDeclaration(Java8Parser.AnnotationTypeDeclarationContext var1);

    void enterAnnotationTypeBody(Java8Parser.AnnotationTypeBodyContext var1);

    void exitAnnotationTypeBody(Java8Parser.AnnotationTypeBodyContext var1);

    void enterAnnotationTypeMemberDeclaration(Java8Parser.AnnotationTypeMemberDeclarationContext var1);

    void exitAnnotationTypeMemberDeclaration(Java8Parser.AnnotationTypeMemberDeclarationContext var1);

    void enterAnnotationTypeElementDeclaration(Java8Parser.AnnotationTypeElementDeclarationContext var1);

    void exitAnnotationTypeElementDeclaration(Java8Parser.AnnotationTypeElementDeclarationContext var1);

    void enterAnnotationTypeElementModifier(Java8Parser.AnnotationTypeElementModifierContext var1);

    void exitAnnotationTypeElementModifier(Java8Parser.AnnotationTypeElementModifierContext var1);

    void enterDefaultValue(Java8Parser.DefaultValueContext var1);

    void exitDefaultValue(Java8Parser.DefaultValueContext var1);

    void enterAnnotation(Java8Parser.AnnotationContext var1);

    void exitAnnotation(Java8Parser.AnnotationContext var1);

    void enterNormalAnnotation(Java8Parser.NormalAnnotationContext var1);

    void exitNormalAnnotation(Java8Parser.NormalAnnotationContext var1);

    void enterElementValuePairList(Java8Parser.ElementValuePairListContext var1);

    void exitElementValuePairList(Java8Parser.ElementValuePairListContext var1);

    void enterElementValuePair(Java8Parser.ElementValuePairContext var1);

    void exitElementValuePair(Java8Parser.ElementValuePairContext var1);

    void enterElementValue(Java8Parser.ElementValueContext var1);

    void exitElementValue(Java8Parser.ElementValueContext var1);

    void enterElementValueArrayInitializer(Java8Parser.ElementValueArrayInitializerContext var1);

    void exitElementValueArrayInitializer(Java8Parser.ElementValueArrayInitializerContext var1);

    void enterElementValueList(Java8Parser.ElementValueListContext var1);

    void exitElementValueList(Java8Parser.ElementValueListContext var1);

    void enterMarkerAnnotation(Java8Parser.MarkerAnnotationContext var1);

    void exitMarkerAnnotation(Java8Parser.MarkerAnnotationContext var1);

    void enterSingleElementAnnotation(Java8Parser.SingleElementAnnotationContext var1);

    void exitSingleElementAnnotation(Java8Parser.SingleElementAnnotationContext var1);

    void enterArrayInitializer(Java8Parser.ArrayInitializerContext var1);

    void exitArrayInitializer(Java8Parser.ArrayInitializerContext var1);

    void enterVariableInitializerList(Java8Parser.VariableInitializerListContext var1);

    void exitVariableInitializerList(Java8Parser.VariableInitializerListContext var1);

    void enterBlock(Java8Parser.BlockContext var1);

    void exitBlock(Java8Parser.BlockContext var1);

    void enterBlockStatements(Java8Parser.BlockStatementsContext var1);

    void exitBlockStatements(Java8Parser.BlockStatementsContext var1);

    void enterBlockStatement(Java8Parser.BlockStatementContext var1);

    void exitBlockStatement(Java8Parser.BlockStatementContext var1);

    void enterLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext var1);

    void exitLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext var1);

    void enterLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext var1);

    void exitLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext var1);

    void enterStatement(Java8Parser.StatementContext var1);

    void exitStatement(Java8Parser.StatementContext var1);

    void enterStatementNoShortIf(Java8Parser.StatementNoShortIfContext var1);

    void exitStatementNoShortIf(Java8Parser.StatementNoShortIfContext var1);

    void enterStatementWithoutTrailingSubstatement(Java8Parser.StatementWithoutTrailingSubstatementContext var1);

    void exitStatementWithoutTrailingSubstatement(Java8Parser.StatementWithoutTrailingSubstatementContext var1);

    void enterEmptyStatement(Java8Parser.EmptyStatementContext var1);

    void exitEmptyStatement(Java8Parser.EmptyStatementContext var1);

    void enterLabeledStatement(Java8Parser.LabeledStatementContext var1);

    void exitLabeledStatement(Java8Parser.LabeledStatementContext var1);

    void enterLabeledStatementNoShortIf(Java8Parser.LabeledStatementNoShortIfContext var1);

    void exitLabeledStatementNoShortIf(Java8Parser.LabeledStatementNoShortIfContext var1);

    void enterExpressionStatement(Java8Parser.ExpressionStatementContext var1);

    void exitExpressionStatement(Java8Parser.ExpressionStatementContext var1);

    void enterStatementExpression(Java8Parser.StatementExpressionContext var1);

    void exitStatementExpression(Java8Parser.StatementExpressionContext var1);

    void enterIfThenStatement(Java8Parser.IfThenStatementContext var1);

    void exitIfThenStatement(Java8Parser.IfThenStatementContext var1);

    void enterIfThenElseStatement(Java8Parser.IfThenElseStatementContext var1);

    void exitIfThenElseStatement(Java8Parser.IfThenElseStatementContext var1);

    void enterIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext var1);

    void exitIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext var1);

    void enterAssertStatement(Java8Parser.AssertStatementContext var1);

    void exitAssertStatement(Java8Parser.AssertStatementContext var1);

    void enterSwitchStatement(Java8Parser.SwitchStatementContext var1);

    void exitSwitchStatement(Java8Parser.SwitchStatementContext var1);

    void enterSwitchBlock(Java8Parser.SwitchBlockContext var1);

    void exitSwitchBlock(Java8Parser.SwitchBlockContext var1);

    void enterSwitchBlockStatementGroup(Java8Parser.SwitchBlockStatementGroupContext var1);

    void exitSwitchBlockStatementGroup(Java8Parser.SwitchBlockStatementGroupContext var1);

    void enterSwitchLabels(Java8Parser.SwitchLabelsContext var1);

    void exitSwitchLabels(Java8Parser.SwitchLabelsContext var1);

    void enterSwitchLabel(Java8Parser.SwitchLabelContext var1);

    void exitSwitchLabel(Java8Parser.SwitchLabelContext var1);

    void enterEnumConstantName(Java8Parser.EnumConstantNameContext var1);

    void exitEnumConstantName(Java8Parser.EnumConstantNameContext var1);

    void enterWhileStatement(Java8Parser.WhileStatementContext var1);

    void exitWhileStatement(Java8Parser.WhileStatementContext var1);

    void enterWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext var1);

    void exitWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext var1);

    void enterDoStatement(Java8Parser.DoStatementContext var1);

    void exitDoStatement(Java8Parser.DoStatementContext var1);

    void enterForStatement(Java8Parser.ForStatementContext var1);

    void exitForStatement(Java8Parser.ForStatementContext var1);

    void enterForStatementNoShortIf(Java8Parser.ForStatementNoShortIfContext var1);

    void exitForStatementNoShortIf(Java8Parser.ForStatementNoShortIfContext var1);

    void enterBasicForStatement(Java8Parser.BasicForStatementContext var1);

    void exitBasicForStatement(Java8Parser.BasicForStatementContext var1);

    void enterBasicForStatementNoShortIf(Java8Parser.BasicForStatementNoShortIfContext var1);

    void exitBasicForStatementNoShortIf(Java8Parser.BasicForStatementNoShortIfContext var1);

    void enterForInit(Java8Parser.ForInitContext var1);

    void exitForInit(Java8Parser.ForInitContext var1);

    void enterForUpdate(Java8Parser.ForUpdateContext var1);

    void exitForUpdate(Java8Parser.ForUpdateContext var1);

    void enterStatementExpressionList(Java8Parser.StatementExpressionListContext var1);

    void exitStatementExpressionList(Java8Parser.StatementExpressionListContext var1);

    void enterEnhancedForStatement(Java8Parser.EnhancedForStatementContext var1);

    void exitEnhancedForStatement(Java8Parser.EnhancedForStatementContext var1);

    void enterEnhancedForStatementNoShortIf(Java8Parser.EnhancedForStatementNoShortIfContext var1);

    void exitEnhancedForStatementNoShortIf(Java8Parser.EnhancedForStatementNoShortIfContext var1);

    void enterBreakStatement(Java8Parser.BreakStatementContext var1);

    void exitBreakStatement(Java8Parser.BreakStatementContext var1);

    void enterContinueStatement(Java8Parser.ContinueStatementContext var1);

    void exitContinueStatement(Java8Parser.ContinueStatementContext var1);

    void enterReturnStatement(Java8Parser.ReturnStatementContext var1);

    void exitReturnStatement(Java8Parser.ReturnStatementContext var1);

    void enterThrowStatement(Java8Parser.ThrowStatementContext var1);

    void exitThrowStatement(Java8Parser.ThrowStatementContext var1);

    void enterSynchronizedStatement(Java8Parser.SynchronizedStatementContext var1);

    void exitSynchronizedStatement(Java8Parser.SynchronizedStatementContext var1);

    void enterTryStatement(Java8Parser.TryStatementContext var1);

    void exitTryStatement(Java8Parser.TryStatementContext var1);

    void enterCatches(Java8Parser.CatchesContext var1);

    void exitCatches(Java8Parser.CatchesContext var1);

    void enterCatchClause(Java8Parser.CatchClauseContext var1);

    void exitCatchClause(Java8Parser.CatchClauseContext var1);

    void enterCatchFormalParameter(Java8Parser.CatchFormalParameterContext var1);

    void exitCatchFormalParameter(Java8Parser.CatchFormalParameterContext var1);

    void enterCatchType(Java8Parser.CatchTypeContext var1);

    void exitCatchType(Java8Parser.CatchTypeContext var1);

    void enterFinally_(Java8Parser.Finally_Context var1);

    void exitFinally_(Java8Parser.Finally_Context var1);

    void enterTryWithResourcesStatement(Java8Parser.TryWithResourcesStatementContext var1);

    void exitTryWithResourcesStatement(Java8Parser.TryWithResourcesStatementContext var1);

    void enterResourceSpecification(Java8Parser.ResourceSpecificationContext var1);

    void exitResourceSpecification(Java8Parser.ResourceSpecificationContext var1);

    void enterResourceList(Java8Parser.ResourceListContext var1);

    void exitResourceList(Java8Parser.ResourceListContext var1);

    void enterResource(Java8Parser.ResourceContext var1);

    void exitResource(Java8Parser.ResourceContext var1);

    void enterPrimary(Java8Parser.PrimaryContext var1);

    void exitPrimary(Java8Parser.PrimaryContext var1);

    void enterPrimaryNoNewArray(Java8Parser.PrimaryNoNewArrayContext var1);

    void exitPrimaryNoNewArray(Java8Parser.PrimaryNoNewArrayContext var1);

    void enterPrimaryNoNewArray_lf_arrayAccess(Java8Parser.PrimaryNoNewArray_lf_arrayAccessContext var1);

    void exitPrimaryNoNewArray_lf_arrayAccess(Java8Parser.PrimaryNoNewArray_lf_arrayAccessContext var1);

    void enterPrimaryNoNewArray_lfno_arrayAccess(Java8Parser.PrimaryNoNewArray_lfno_arrayAccessContext var1);

    void exitPrimaryNoNewArray_lfno_arrayAccess(Java8Parser.PrimaryNoNewArray_lfno_arrayAccessContext var1);

    void enterPrimaryNoNewArray_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext var1);

    void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext var1);

    void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext var1);

    void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext var1);

    void enterClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext var1);

    void exitClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext var1);

    void enterClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext var1);

    void exitClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext var1);

    void enterClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext var1);

    void exitClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext var1);

    void enterTypeArgumentsOrDiamond(Java8Parser.TypeArgumentsOrDiamondContext var1);

    void exitTypeArgumentsOrDiamond(Java8Parser.TypeArgumentsOrDiamondContext var1);

    void enterFieldAccess(Java8Parser.FieldAccessContext var1);

    void exitFieldAccess(Java8Parser.FieldAccessContext var1);

    void enterFieldAccess_lf_primary(Java8Parser.FieldAccess_lf_primaryContext var1);

    void exitFieldAccess_lf_primary(Java8Parser.FieldAccess_lf_primaryContext var1);

    void enterFieldAccess_lfno_primary(Java8Parser.FieldAccess_lfno_primaryContext var1);

    void exitFieldAccess_lfno_primary(Java8Parser.FieldAccess_lfno_primaryContext var1);

    void enterArrayAccess(Java8Parser.ArrayAccessContext var1);

    void exitArrayAccess(Java8Parser.ArrayAccessContext var1);

    void enterArrayAccess_lf_primary(Java8Parser.ArrayAccess_lf_primaryContext var1);

    void exitArrayAccess_lf_primary(Java8Parser.ArrayAccess_lf_primaryContext var1);

    void enterArrayAccess_lfno_primary(Java8Parser.ArrayAccess_lfno_primaryContext var1);

    void exitArrayAccess_lfno_primary(Java8Parser.ArrayAccess_lfno_primaryContext var1);

    void enterMethodInvocation(Java8Parser.MethodInvocationContext var1);

    void exitMethodInvocation(Java8Parser.MethodInvocationContext var1);

    void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext var1);

    void exitMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext var1);

    void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext var1);

    void exitMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext var1);

    void enterArgumentList(Java8Parser.ArgumentListContext var1);

    void exitArgumentList(Java8Parser.ArgumentListContext var1);

    void enterMethodReference(Java8Parser.MethodReferenceContext var1);

    void exitMethodReference(Java8Parser.MethodReferenceContext var1);

    void enterMethodReference_lf_primary(Java8Parser.MethodReference_lf_primaryContext var1);

    void exitMethodReference_lf_primary(Java8Parser.MethodReference_lf_primaryContext var1);

    void enterMethodReference_lfno_primary(Java8Parser.MethodReference_lfno_primaryContext var1);

    void exitMethodReference_lfno_primary(Java8Parser.MethodReference_lfno_primaryContext var1);

    void enterArrayCreationExpression(Java8Parser.ArrayCreationExpressionContext var1);

    void exitArrayCreationExpression(Java8Parser.ArrayCreationExpressionContext var1);

    void enterDimExprs(Java8Parser.DimExprsContext var1);

    void exitDimExprs(Java8Parser.DimExprsContext var1);

    void enterDimExpr(Java8Parser.DimExprContext var1);

    void exitDimExpr(Java8Parser.DimExprContext var1);

    void enterConstantExpression(Java8Parser.ConstantExpressionContext var1);

    void exitConstantExpression(Java8Parser.ConstantExpressionContext var1);

    void enterExpression(Java8Parser.ExpressionContext var1);

    void exitExpression(Java8Parser.ExpressionContext var1);

    void enterLambdaExpression(Java8Parser.LambdaExpressionContext var1);

    void exitLambdaExpression(Java8Parser.LambdaExpressionContext var1);

    void enterLambdaParameters(Java8Parser.LambdaParametersContext var1);

    void exitLambdaParameters(Java8Parser.LambdaParametersContext var1);

    void enterInferredFormalParameterList(Java8Parser.InferredFormalParameterListContext var1);

    void exitInferredFormalParameterList(Java8Parser.InferredFormalParameterListContext var1);

    void enterLambdaBody(Java8Parser.LambdaBodyContext var1);

    void exitLambdaBody(Java8Parser.LambdaBodyContext var1);

    void enterAssignmentExpression(Java8Parser.AssignmentExpressionContext var1);

    void exitAssignmentExpression(Java8Parser.AssignmentExpressionContext var1);

    void enterAssignment(Java8Parser.AssignmentContext var1);

    void exitAssignment(Java8Parser.AssignmentContext var1);

    void enterLeftHandSide(Java8Parser.LeftHandSideContext var1);

    void exitLeftHandSide(Java8Parser.LeftHandSideContext var1);

    void enterAssignmentOperator(Java8Parser.AssignmentOperatorContext var1);

    void exitAssignmentOperator(Java8Parser.AssignmentOperatorContext var1);

    void enterConditionalExpression(Java8Parser.ConditionalExpressionContext var1);

    void exitConditionalExpression(Java8Parser.ConditionalExpressionContext var1);

    void enterConditionalOrExpression(Java8Parser.ConditionalOrExpressionContext var1);

    void exitConditionalOrExpression(Java8Parser.ConditionalOrExpressionContext var1);

    void enterConditionalAndExpression(Java8Parser.ConditionalAndExpressionContext var1);

    void exitConditionalAndExpression(Java8Parser.ConditionalAndExpressionContext var1);

    void enterInclusiveOrExpression(Java8Parser.InclusiveOrExpressionContext var1);

    void exitInclusiveOrExpression(Java8Parser.InclusiveOrExpressionContext var1);

    void enterExclusiveOrExpression(Java8Parser.ExclusiveOrExpressionContext var1);

    void exitExclusiveOrExpression(Java8Parser.ExclusiveOrExpressionContext var1);

    void enterAndExpression(Java8Parser.AndExpressionContext var1);

    void exitAndExpression(Java8Parser.AndExpressionContext var1);

    void enterEqualityExpression(Java8Parser.EqualityExpressionContext var1);

    void exitEqualityExpression(Java8Parser.EqualityExpressionContext var1);

    void enterRelationalExpression(Java8Parser.RelationalExpressionContext var1);

    void exitRelationalExpression(Java8Parser.RelationalExpressionContext var1);

    void enterShiftExpression(Java8Parser.ShiftExpressionContext var1);

    void exitShiftExpression(Java8Parser.ShiftExpressionContext var1);

    void enterAdditiveExpression(Java8Parser.AdditiveExpressionContext var1);

    void exitAdditiveExpression(Java8Parser.AdditiveExpressionContext var1);

    void enterMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext var1);

    void exitMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext var1);

    void enterUnaryExpression(Java8Parser.UnaryExpressionContext var1);

    void exitUnaryExpression(Java8Parser.UnaryExpressionContext var1);

    void enterPreIncrementExpression(Java8Parser.PreIncrementExpressionContext var1);

    void exitPreIncrementExpression(Java8Parser.PreIncrementExpressionContext var1);

    void enterPreDecrementExpression(Java8Parser.PreDecrementExpressionContext var1);

    void exitPreDecrementExpression(Java8Parser.PreDecrementExpressionContext var1);

    void enterUnaryExpressionNotPlusMinus(Java8Parser.UnaryExpressionNotPlusMinusContext var1);

    void exitUnaryExpressionNotPlusMinus(Java8Parser.UnaryExpressionNotPlusMinusContext var1);

    void enterPostfixExpression(Java8Parser.PostfixExpressionContext var1);

    void exitPostfixExpression(Java8Parser.PostfixExpressionContext var1);

    void enterPostIncrementExpression(Java8Parser.PostIncrementExpressionContext var1);

    void exitPostIncrementExpression(Java8Parser.PostIncrementExpressionContext var1);

    void enterPostIncrementExpression_lf_postfixExpression(Java8Parser.PostIncrementExpression_lf_postfixExpressionContext var1);

    void exitPostIncrementExpression_lf_postfixExpression(Java8Parser.PostIncrementExpression_lf_postfixExpressionContext var1);

    void enterPostDecrementExpression(Java8Parser.PostDecrementExpressionContext var1);

    void exitPostDecrementExpression(Java8Parser.PostDecrementExpressionContext var1);

    void enterPostDecrementExpression_lf_postfixExpression(Java8Parser.PostDecrementExpression_lf_postfixExpressionContext var1);

    void exitPostDecrementExpression_lf_postfixExpression(Java8Parser.PostDecrementExpression_lf_postfixExpressionContext var1);

    void enterCastExpression(Java8Parser.CastExpressionContext var1);

    void exitCastExpression(Java8Parser.CastExpressionContext var1);
}

