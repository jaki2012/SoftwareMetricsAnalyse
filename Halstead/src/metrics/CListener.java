package metrics;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import metrics.CParser.*;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface CListener extends ParseTreeListener {
    void enterPrimaryExpression(PrimaryExpressionContext var1);

    void exitPrimaryExpression(PrimaryExpressionContext var1);

    void enterGenericSelection(GenericSelectionContext var1);

    void exitGenericSelection(GenericSelectionContext var1);

    void enterGenericAssocList(GenericAssocListContext var1);

    void exitGenericAssocList(GenericAssocListContext var1);

    void enterGenericAssociation(GenericAssociationContext var1);

    void exitGenericAssociation(GenericAssociationContext var1);

    void enterPostfixExpression(PostfixExpressionContext var1);

    void exitPostfixExpression(PostfixExpressionContext var1);

    void enterArgumentExpressionList(ArgumentExpressionListContext var1);

    void exitArgumentExpressionList(ArgumentExpressionListContext var1);

    void enterUnaryExpression(UnaryExpressionContext var1);

    void exitUnaryExpression(UnaryExpressionContext var1);

    void enterUnaryOperator(UnaryOperatorContext var1);

    void exitUnaryOperator(UnaryOperatorContext var1);

    void enterCastExpression(CastExpressionContext var1);

    void exitCastExpression(CastExpressionContext var1);

    void enterMultiplicativeExpression(MultiplicativeExpressionContext var1);

    void exitMultiplicativeExpression(MultiplicativeExpressionContext var1);

    void enterAdditiveExpression(AdditiveExpressionContext var1);

    void exitAdditiveExpression(AdditiveExpressionContext var1);

    void enterShiftExpression(ShiftExpressionContext var1);

    void exitShiftExpression(ShiftExpressionContext var1);

    void enterRelationalExpression(RelationalExpressionContext var1);

    void exitRelationalExpression(RelationalExpressionContext var1);

    void enterEqualityExpression(EqualityExpressionContext var1);

    void exitEqualityExpression(EqualityExpressionContext var1);

    void enterAndExpression(AndExpressionContext var1);

    void exitAndExpression(AndExpressionContext var1);

    void enterExclusiveOrExpression(ExclusiveOrExpressionContext var1);

    void exitExclusiveOrExpression(ExclusiveOrExpressionContext var1);

    void enterInclusiveOrExpression(InclusiveOrExpressionContext var1);

    void exitInclusiveOrExpression(InclusiveOrExpressionContext var1);

    void enterLogicalAndExpression(LogicalAndExpressionContext var1);

    void exitLogicalAndExpression(LogicalAndExpressionContext var1);

    void enterLogicalOrExpression(LogicalOrExpressionContext var1);

    void exitLogicalOrExpression(LogicalOrExpressionContext var1);

    void enterConditionalExpression(ConditionalExpressionContext var1);

    void exitConditionalExpression(ConditionalExpressionContext var1);

    void enterAssignmentExpression(AssignmentExpressionContext var1);

    void exitAssignmentExpression(AssignmentExpressionContext var1);

    void enterAssignmentOperator(AssignmentOperatorContext var1);

    void exitAssignmentOperator(AssignmentOperatorContext var1);

    void enterExpression(ExpressionContext var1);

    void exitExpression(ExpressionContext var1);

    void enterConstantExpression(ConstantExpressionContext var1);

    void exitConstantExpression(ConstantExpressionContext var1);

    void enterDeclaration(DeclarationContext var1);

    void exitDeclaration(DeclarationContext var1);

    void enterDeclarationSpecifiers(DeclarationSpecifiersContext var1);

    void exitDeclarationSpecifiers(DeclarationSpecifiersContext var1);

    void enterDeclarationSpecifiers2(DeclarationSpecifiers2Context var1);

    void exitDeclarationSpecifiers2(DeclarationSpecifiers2Context var1);

    void enterDeclarationSpecifier(DeclarationSpecifierContext var1);

    void exitDeclarationSpecifier(DeclarationSpecifierContext var1);

    void enterInitDeclaratorList(InitDeclaratorListContext var1);

    void exitInitDeclaratorList(InitDeclaratorListContext var1);

    void enterInitDeclarator(InitDeclaratorContext var1);

    void exitInitDeclarator(InitDeclaratorContext var1);

    void enterStorageClassSpecifier(StorageClassSpecifierContext var1);

    void exitStorageClassSpecifier(StorageClassSpecifierContext var1);

    void enterTypeSpecifier(TypeSpecifierContext var1);

    void exitTypeSpecifier(TypeSpecifierContext var1);

    void enterStructOrUnionSpecifier(StructOrUnionSpecifierContext var1);

    void exitStructOrUnionSpecifier(StructOrUnionSpecifierContext var1);

    void enterStructOrUnion(StructOrUnionContext var1);

    void exitStructOrUnion(StructOrUnionContext var1);

    void enterStructDeclarationList(StructDeclarationListContext var1);

    void exitStructDeclarationList(StructDeclarationListContext var1);

    void enterStructDeclaration(StructDeclarationContext var1);

    void exitStructDeclaration(StructDeclarationContext var1);

    void enterSpecifierQualifierList(SpecifierQualifierListContext var1);

    void exitSpecifierQualifierList(SpecifierQualifierListContext var1);

    void enterStructDeclaratorList(StructDeclaratorListContext var1);

    void exitStructDeclaratorList(StructDeclaratorListContext var1);

    void enterStructDeclarator(StructDeclaratorContext var1);

    void exitStructDeclarator(StructDeclaratorContext var1);

    void enterEnumSpecifier(EnumSpecifierContext var1);

    void exitEnumSpecifier(EnumSpecifierContext var1);

    void enterEnumeratorList(EnumeratorListContext var1);

    void exitEnumeratorList(EnumeratorListContext var1);

    void enterEnumerator(EnumeratorContext var1);

    void exitEnumerator(EnumeratorContext var1);

    void enterEnumerationConstant(EnumerationConstantContext var1);

    void exitEnumerationConstant(EnumerationConstantContext var1);

    void enterAtomicTypeSpecifier(AtomicTypeSpecifierContext var1);

    void exitAtomicTypeSpecifier(AtomicTypeSpecifierContext var1);

    void enterTypeQualifier(TypeQualifierContext var1);

    void exitTypeQualifier(TypeQualifierContext var1);

    void enterFunctionSpecifier(FunctionSpecifierContext var1);

    void exitFunctionSpecifier(FunctionSpecifierContext var1);

    void enterAlignmentSpecifier(AlignmentSpecifierContext var1);

    void exitAlignmentSpecifier(AlignmentSpecifierContext var1);

    void enterDeclarator(DeclaratorContext var1);

    void exitDeclarator(DeclaratorContext var1);

    void enterDirectDeclarator(DirectDeclaratorContext var1);

    void exitDirectDeclarator(DirectDeclaratorContext var1);

    void enterGccDeclaratorExtension(GccDeclaratorExtensionContext var1);

    void exitGccDeclaratorExtension(GccDeclaratorExtensionContext var1);

    void enterGccAttributeSpecifier(GccAttributeSpecifierContext var1);

    void exitGccAttributeSpecifier(GccAttributeSpecifierContext var1);

    void enterGccAttributeList(GccAttributeListContext var1);

    void exitGccAttributeList(GccAttributeListContext var1);

    void enterGccAttribute(GccAttributeContext var1);

    void exitGccAttribute(GccAttributeContext var1);

    void enterNestedParenthesesBlock(NestedParenthesesBlockContext var1);

    void exitNestedParenthesesBlock(NestedParenthesesBlockContext var1);

    void enterPointer(PointerContext var1);

    void exitPointer(PointerContext var1);

    void enterTypeQualifierList(TypeQualifierListContext var1);

    void exitTypeQualifierList(TypeQualifierListContext var1);

    void enterParameterTypeList(ParameterTypeListContext var1);

    void exitParameterTypeList(ParameterTypeListContext var1);

    void enterParameterList(ParameterListContext var1);

    void exitParameterList(ParameterListContext var1);

    void enterParameterDeclaration(ParameterDeclarationContext var1);

    void exitParameterDeclaration(ParameterDeclarationContext var1);

    void enterIdentifierList(IdentifierListContext var1);

    void exitIdentifierList(IdentifierListContext var1);

    void enterTypeName(TypeNameContext var1);

    void exitTypeName(TypeNameContext var1);

    void enterAbstractDeclarator(AbstractDeclaratorContext var1);

    void exitAbstractDeclarator(AbstractDeclaratorContext var1);

    void enterDirectAbstractDeclarator(DirectAbstractDeclaratorContext var1);

    void exitDirectAbstractDeclarator(DirectAbstractDeclaratorContext var1);

    void enterTypedefName(TypedefNameContext var1);

    void exitTypedefName(TypedefNameContext var1);

    void enterInitializer(InitializerContext var1);

    void exitInitializer(InitializerContext var1);

    void enterInitializerList(InitializerListContext var1);

    void exitInitializerList(InitializerListContext var1);

    void enterDesignation(DesignationContext var1);

    void exitDesignation(DesignationContext var1);

    void enterDesignatorList(DesignatorListContext var1);

    void exitDesignatorList(DesignatorListContext var1);

    void enterDesignator(DesignatorContext var1);

    void exitDesignator(DesignatorContext var1);

    void enterStaticAssertDeclaration(StaticAssertDeclarationContext var1);

    void exitStaticAssertDeclaration(StaticAssertDeclarationContext var1);

    void enterStatement(StatementContext var1);

    void exitStatement(StatementContext var1);

    void enterLabeledStatement(LabeledStatementContext var1);

    void exitLabeledStatement(LabeledStatementContext var1);

    void enterCompoundStatement(CompoundStatementContext var1);

    void exitCompoundStatement(CompoundStatementContext var1);

    void enterBlockItemList(BlockItemListContext var1);

    void exitBlockItemList(BlockItemListContext var1);

    void enterBlockItem(BlockItemContext var1);

    void exitBlockItem(BlockItemContext var1);

    void enterExpressionStatement(ExpressionStatementContext var1);

    void exitExpressionStatement(ExpressionStatementContext var1);

    void enterSelectionStatement(SelectionStatementContext var1);

    void exitSelectionStatement(SelectionStatementContext var1);

    void enterIterationStatement(IterationStatementContext var1);

    void exitIterationStatement(IterationStatementContext var1);

    void enterJumpStatement(JumpStatementContext var1);

    void exitJumpStatement(JumpStatementContext var1);

    void enterCompilationUnit(CompilationUnitContext var1);

    void exitCompilationUnit(CompilationUnitContext var1);

    void enterTranslationUnit(TranslationUnitContext var1);

    void exitTranslationUnit(TranslationUnitContext var1);

    void enterExternalDeclaration(ExternalDeclarationContext var1);

    void exitExternalDeclaration(ExternalDeclarationContext var1);

    void enterFunctionDefinition(FunctionDefinitionContext var1);

    void exitFunctionDefinition(FunctionDefinitionContext var1);

    void enterDeclarationList(DeclarationListContext var1);

    void exitDeclarationList(DeclarationListContext var1);
}
