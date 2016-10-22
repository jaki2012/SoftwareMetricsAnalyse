package metrics.c;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface CListener extends ParseTreeListener {
    void enterPrimaryExpression(CParser.PrimaryExpressionContext var1);

    void exitPrimaryExpression(CParser.PrimaryExpressionContext var1);

    void enterGenericSelection(CParser.GenericSelectionContext var1);

    void exitGenericSelection(CParser.GenericSelectionContext var1);

    void enterGenericAssocList(CParser.GenericAssocListContext var1);

    void exitGenericAssocList(CParser.GenericAssocListContext var1);

    void enterGenericAssociation(CParser.GenericAssociationContext var1);

    void exitGenericAssociation(CParser.GenericAssociationContext var1);

    void enterPostfixExpression(CParser.PostfixExpressionContext var1);

    void exitPostfixExpression(CParser.PostfixExpressionContext var1);

    void enterArgumentExpressionList(CParser.ArgumentExpressionListContext var1);

    void exitArgumentExpressionList(CParser.ArgumentExpressionListContext var1);

    void enterUnaryExpression(CParser.UnaryExpressionContext var1);

    void exitUnaryExpression(CParser.UnaryExpressionContext var1);

    void enterUnaryOperator(CParser.UnaryOperatorContext var1);

    void exitUnaryOperator(CParser.UnaryOperatorContext var1);

    void enterCastExpression(CParser.CastExpressionContext var1);

    void exitCastExpression(CParser.CastExpressionContext var1);

    void enterMultiplicativeExpression(CParser.MultiplicativeExpressionContext var1);

    void exitMultiplicativeExpression(CParser.MultiplicativeExpressionContext var1);

    void enterAdditiveExpression(CParser.AdditiveExpressionContext var1);

    void exitAdditiveExpression(CParser.AdditiveExpressionContext var1);

    void enterShiftExpression(CParser.ShiftExpressionContext var1);

    void exitShiftExpression(CParser.ShiftExpressionContext var1);

    void enterRelationalExpression(CParser.RelationalExpressionContext var1);

    void exitRelationalExpression(CParser.RelationalExpressionContext var1);

    void enterEqualityExpression(CParser.EqualityExpressionContext var1);

    void exitEqualityExpression(CParser.EqualityExpressionContext var1);

    void enterAndExpression(CParser.AndExpressionContext var1);

    void exitAndExpression(CParser.AndExpressionContext var1);

    void enterExclusiveOrExpression(CParser.ExclusiveOrExpressionContext var1);

    void exitExclusiveOrExpression(CParser.ExclusiveOrExpressionContext var1);

    void enterInclusiveOrExpression(CParser.InclusiveOrExpressionContext var1);

    void exitInclusiveOrExpression(CParser.InclusiveOrExpressionContext var1);

    void enterLogicalAndExpression(CParser.LogicalAndExpressionContext var1);

    void exitLogicalAndExpression(CParser.LogicalAndExpressionContext var1);

    void enterLogicalOrExpression(CParser.LogicalOrExpressionContext var1);

    void exitLogicalOrExpression(CParser.LogicalOrExpressionContext var1);

    void enterConditionalExpression(CParser.ConditionalExpressionContext var1);

    void exitConditionalExpression(CParser.ConditionalExpressionContext var1);

    void enterAssignmentExpression(CParser.AssignmentExpressionContext var1);

    void exitAssignmentExpression(CParser.AssignmentExpressionContext var1);

    void enterAssignmentOperator(CParser.AssignmentOperatorContext var1);

    void exitAssignmentOperator(CParser.AssignmentOperatorContext var1);

    void enterExpression(CParser.ExpressionContext var1);

    void exitExpression(CParser.ExpressionContext var1);

    void enterConstantExpression(CParser.ConstantExpressionContext var1);

    void exitConstantExpression(CParser.ConstantExpressionContext var1);

    void enterDeclaration(CParser.DeclarationContext var1);

    void exitDeclaration(CParser.DeclarationContext var1);

    void enterDeclarationSpecifiers(CParser.DeclarationSpecifiersContext var1);

    void exitDeclarationSpecifiers(CParser.DeclarationSpecifiersContext var1);

    void enterDeclarationSpecifiers2(CParser.DeclarationSpecifiers2Context var1);

    void exitDeclarationSpecifiers2(CParser.DeclarationSpecifiers2Context var1);

    void enterDeclarationSpecifier(CParser.DeclarationSpecifierContext var1);

    void exitDeclarationSpecifier(CParser.DeclarationSpecifierContext var1);

    void enterInitDeclaratorList(CParser.InitDeclaratorListContext var1);

    void exitInitDeclaratorList(CParser.InitDeclaratorListContext var1);

    void enterInitDeclarator(CParser.InitDeclaratorContext var1);

    void exitInitDeclarator(CParser.InitDeclaratorContext var1);

    void enterStorageClassSpecifier(CParser.StorageClassSpecifierContext var1);

    void exitStorageClassSpecifier(CParser.StorageClassSpecifierContext var1);

    void enterTypeSpecifier(CParser.TypeSpecifierContext var1);

    void exitTypeSpecifier(CParser.TypeSpecifierContext var1);

    void enterStructOrUnionSpecifier(CParser.StructOrUnionSpecifierContext var1);

    void exitStructOrUnionSpecifier(CParser.StructOrUnionSpecifierContext var1);

    void enterStructOrUnion(CParser.StructOrUnionContext var1);

    void exitStructOrUnion(CParser.StructOrUnionContext var1);

    void enterStructDeclarationList(CParser.StructDeclarationListContext var1);

    void exitStructDeclarationList(CParser.StructDeclarationListContext var1);

    void enterStructDeclaration(CParser.StructDeclarationContext var1);

    void exitStructDeclaration(CParser.StructDeclarationContext var1);

    void enterSpecifierQualifierList(CParser.SpecifierQualifierListContext var1);

    void exitSpecifierQualifierList(CParser.SpecifierQualifierListContext var1);

    void enterStructDeclaratorList(CParser.StructDeclaratorListContext var1);

    void exitStructDeclaratorList(CParser.StructDeclaratorListContext var1);

    void enterStructDeclarator(CParser.StructDeclaratorContext var1);

    void exitStructDeclarator(CParser.StructDeclaratorContext var1);

    void enterEnumSpecifier(CParser.EnumSpecifierContext var1);

    void exitEnumSpecifier(CParser.EnumSpecifierContext var1);

    void enterEnumeratorList(CParser.EnumeratorListContext var1);

    void exitEnumeratorList(CParser.EnumeratorListContext var1);

    void enterEnumerator(CParser.EnumeratorContext var1);

    void exitEnumerator(CParser.EnumeratorContext var1);

    void enterEnumerationConstant(CParser.EnumerationConstantContext var1);

    void exitEnumerationConstant(CParser.EnumerationConstantContext var1);

    void enterAtomicTypeSpecifier(CParser.AtomicTypeSpecifierContext var1);

    void exitAtomicTypeSpecifier(CParser.AtomicTypeSpecifierContext var1);

    void enterTypeQualifier(CParser.TypeQualifierContext var1);

    void exitTypeQualifier(CParser.TypeQualifierContext var1);

    void enterFunctionSpecifier(CParser.FunctionSpecifierContext var1);

    void exitFunctionSpecifier(CParser.FunctionSpecifierContext var1);

    void enterAlignmentSpecifier(CParser.AlignmentSpecifierContext var1);

    void exitAlignmentSpecifier(CParser.AlignmentSpecifierContext var1);

    void enterDeclarator(CParser.DeclaratorContext var1);

    void exitDeclarator(CParser.DeclaratorContext var1);

    void enterDirectDeclarator(CParser.DirectDeclaratorContext var1);

    void exitDirectDeclarator(CParser.DirectDeclaratorContext var1);

    void enterGccDeclaratorExtension(CParser.GccDeclaratorExtensionContext var1);

    void exitGccDeclaratorExtension(CParser.GccDeclaratorExtensionContext var1);

    void enterGccAttributeSpecifier(CParser.GccAttributeSpecifierContext var1);

    void exitGccAttributeSpecifier(CParser.GccAttributeSpecifierContext var1);

    void enterGccAttributeList(CParser.GccAttributeListContext var1);

    void exitGccAttributeList(CParser.GccAttributeListContext var1);

    void enterGccAttribute(CParser.GccAttributeContext var1);

    void exitGccAttribute(CParser.GccAttributeContext var1);

    void enterNestedParenthesesBlock(CParser.NestedParenthesesBlockContext var1);

    void exitNestedParenthesesBlock(CParser.NestedParenthesesBlockContext var1);

    void enterPointer(CParser.PointerContext var1);

    void exitPointer(CParser.PointerContext var1);

    void enterTypeQualifierList(CParser.TypeQualifierListContext var1);

    void exitTypeQualifierList(CParser.TypeQualifierListContext var1);

    void enterParameterTypeList(CParser.ParameterTypeListContext var1);

    void exitParameterTypeList(CParser.ParameterTypeListContext var1);

    void enterParameterList(CParser.ParameterListContext var1);

    void exitParameterList(CParser.ParameterListContext var1);

    void enterParameterDeclaration(CParser.ParameterDeclarationContext var1);

    void exitParameterDeclaration(CParser.ParameterDeclarationContext var1);

    void enterIdentifierList(CParser.IdentifierListContext var1);

    void exitIdentifierList(CParser.IdentifierListContext var1);

    void enterTypeName(CParser.TypeNameContext var1);

    void exitTypeName(CParser.TypeNameContext var1);

    void enterAbstractDeclarator(CParser.AbstractDeclaratorContext var1);

    void exitAbstractDeclarator(CParser.AbstractDeclaratorContext var1);

    void enterDirectAbstractDeclarator(CParser.DirectAbstractDeclaratorContext var1);

    void exitDirectAbstractDeclarator(CParser.DirectAbstractDeclaratorContext var1);

    void enterTypedefName(CParser.TypedefNameContext var1);

    void exitTypedefName(CParser.TypedefNameContext var1);

    void enterInitializer(CParser.InitializerContext var1);

    void exitInitializer(CParser.InitializerContext var1);

    void enterInitializerList(CParser.InitializerListContext var1);

    void exitInitializerList(CParser.InitializerListContext var1);

    void enterDesignation(CParser.DesignationContext var1);

    void exitDesignation(CParser.DesignationContext var1);

    void enterDesignatorList(CParser.DesignatorListContext var1);

    void exitDesignatorList(CParser.DesignatorListContext var1);

    void enterDesignator(CParser.DesignatorContext var1);

    void exitDesignator(CParser.DesignatorContext var1);

    void enterStaticAssertDeclaration(CParser.StaticAssertDeclarationContext var1);

    void exitStaticAssertDeclaration(CParser.StaticAssertDeclarationContext var1);

    void enterStatement(CParser.StatementContext var1);

    void exitStatement(CParser.StatementContext var1);

    void enterLabeledStatement(CParser.LabeledStatementContext var1);

    void exitLabeledStatement(CParser.LabeledStatementContext var1);

    void enterCompoundStatement(CParser.CompoundStatementContext var1);

    void exitCompoundStatement(CParser.CompoundStatementContext var1);

    void enterBlockItemList(CParser.BlockItemListContext var1);

    void exitBlockItemList(CParser.BlockItemListContext var1);

    void enterBlockItem(CParser.BlockItemContext var1);

    void exitBlockItem(CParser.BlockItemContext var1);

    void enterExpressionStatement(CParser.ExpressionStatementContext var1);

    void exitExpressionStatement(CParser.ExpressionStatementContext var1);

    void enterSelectionStatement(CParser.SelectionStatementContext var1);

    void exitSelectionStatement(CParser.SelectionStatementContext var1);

    void enterIterationStatement(CParser.IterationStatementContext var1);

    void exitIterationStatement(CParser.IterationStatementContext var1);

    void enterJumpStatement(CParser.JumpStatementContext var1);

    void exitJumpStatement(CParser.JumpStatementContext var1);

    void enterCompilationUnit(CParser.CompilationUnitContext var1);

    void exitCompilationUnit(CParser.CompilationUnitContext var1);

    void enterTranslationUnit(CParser.TranslationUnitContext var1);

    void exitTranslationUnit(CParser.TranslationUnitContext var1);

    void enterExternalDeclaration(CParser.ExternalDeclarationContext var1);

    void exitExternalDeclaration(CParser.ExternalDeclarationContext var1);

    void enterFunctionDefinition(CParser.FunctionDefinitionContext var1);

    void exitFunctionDefinition(CParser.FunctionDefinitionContext var1);

    void enterDeclarationList(CParser.DeclarationListContext var1);

    void exitDeclarationList(CParser.DeclarationListContext var1);
}
