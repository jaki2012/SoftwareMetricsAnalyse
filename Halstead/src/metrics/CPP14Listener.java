package metrics;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import metrics.CPP14Parser.*;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface CPP14Listener extends ParseTreeListener {
    void enterTranslationunit(TranslationunitContext var1);

    void exitTranslationunit(TranslationunitContext var1);

    void enterPrimaryexpression(PrimaryexpressionContext var1);

    void exitPrimaryexpression(PrimaryexpressionContext var1);

    void enterIdexpression(IdexpressionContext var1);

    void exitIdexpression(IdexpressionContext var1);

    void enterUnqualifiedid(UnqualifiedidContext var1);

    void exitUnqualifiedid(UnqualifiedidContext var1);

    void enterQualifiedid(QualifiedidContext var1);

    void exitQualifiedid(QualifiedidContext var1);

    void enterNestednamespecifier(NestednamespecifierContext var1);

    void exitNestednamespecifier(NestednamespecifierContext var1);

    void enterLambdaexpression(LambdaexpressionContext var1);

    void exitLambdaexpression(LambdaexpressionContext var1);

    void enterLambdaintroducer(LambdaintroducerContext var1);

    void exitLambdaintroducer(LambdaintroducerContext var1);

    void enterLambdacapture(LambdacaptureContext var1);

    void exitLambdacapture(LambdacaptureContext var1);

    void enterCapturedefault(CapturedefaultContext var1);

    void exitCapturedefault(CapturedefaultContext var1);

    void enterCapturelist(CapturelistContext var1);

    void exitCapturelist(CapturelistContext var1);

    void enterCapture(CaptureContext var1);

    void exitCapture(CaptureContext var1);

    void enterSimplecapture(SimplecaptureContext var1);

    void exitSimplecapture(SimplecaptureContext var1);

    void enterInitcapture(InitcaptureContext var1);

    void exitInitcapture(InitcaptureContext var1);

    void enterLambdadeclarator(LambdadeclaratorContext var1);

    void exitLambdadeclarator(LambdadeclaratorContext var1);

    void enterPostfixexpression(PostfixexpressionContext var1);

    void exitPostfixexpression(PostfixexpressionContext var1);

    void enterExpressionlist(ExpressionlistContext var1);

    void exitExpressionlist(ExpressionlistContext var1);

    void enterPseudodestructorname(PseudodestructornameContext var1);

    void exitPseudodestructorname(PseudodestructornameContext var1);

    void enterUnaryexpression(UnaryexpressionContext var1);

    void exitUnaryexpression(UnaryexpressionContext var1);

    void enterUnaryoperator(UnaryoperatorContext var1);

    void exitUnaryoperator(UnaryoperatorContext var1);

    void enterNewexpression(NewexpressionContext var1);

    void exitNewexpression(NewexpressionContext var1);

    void enterNewplacement(NewplacementContext var1);

    void exitNewplacement(NewplacementContext var1);

    void enterNewtypeid(NewtypeidContext var1);

    void exitNewtypeid(NewtypeidContext var1);

    void enterNewdeclarator(NewdeclaratorContext var1);

    void exitNewdeclarator(NewdeclaratorContext var1);

    void enterNoptrnewdeclarator(NoptrnewdeclaratorContext var1);

    void exitNoptrnewdeclarator(NoptrnewdeclaratorContext var1);

    void enterNewinitializer(NewinitializerContext var1);

    void exitNewinitializer(NewinitializerContext var1);

    void enterDeleteexpression(DeleteexpressionContext var1);

    void exitDeleteexpression(DeleteexpressionContext var1);

    void enterNoexceptexpression(NoexceptexpressionContext var1);

    void exitNoexceptexpression(NoexceptexpressionContext var1);

    void enterCastexpression(CastexpressionContext var1);

    void exitCastexpression(CastexpressionContext var1);

    void enterPmexpression(PmexpressionContext var1);

    void exitPmexpression(PmexpressionContext var1);

    void enterMultiplicativeexpression(MultiplicativeexpressionContext var1);

    void exitMultiplicativeexpression(MultiplicativeexpressionContext var1);

    void enterAdditiveexpression(AdditiveexpressionContext var1);

    void exitAdditiveexpression(AdditiveexpressionContext var1);

    void enterShiftexpression(ShiftexpressionContext var1);

    void exitShiftexpression(ShiftexpressionContext var1);

    void enterRelationalexpression(RelationalexpressionContext var1);

    void exitRelationalexpression(RelationalexpressionContext var1);

    void enterEqualityexpression(EqualityexpressionContext var1);

    void exitEqualityexpression(EqualityexpressionContext var1);

    void enterAndexpression(AndexpressionContext var1);

    void exitAndexpression(AndexpressionContext var1);

    void enterExclusiveorexpression(ExclusiveorexpressionContext var1);

    void exitExclusiveorexpression(ExclusiveorexpressionContext var1);

    void enterInclusiveorexpression(InclusiveorexpressionContext var1);

    void exitInclusiveorexpression(InclusiveorexpressionContext var1);

    void enterLogicalandexpression(LogicalandexpressionContext var1);

    void exitLogicalandexpression(LogicalandexpressionContext var1);

    void enterLogicalorexpression(LogicalorexpressionContext var1);

    void exitLogicalorexpression(LogicalorexpressionContext var1);

    void enterConditionalexpression(ConditionalexpressionContext var1);

    void exitConditionalexpression(ConditionalexpressionContext var1);

    void enterAssignmentexpression(AssignmentexpressionContext var1);

    void exitAssignmentexpression(AssignmentexpressionContext var1);

    void enterAssignmentoperator(AssignmentoperatorContext var1);

    void exitAssignmentoperator(AssignmentoperatorContext var1);

    void enterExpression(ExpressionContext var1);

    void exitExpression(ExpressionContext var1);

    void enterConstantexpression(ConstantexpressionContext var1);

    void exitConstantexpression(ConstantexpressionContext var1);

    void enterStatement(StatementContext var1);

    void exitStatement(StatementContext var1);

    void enterLabeledstatement(LabeledstatementContext var1);

    void exitLabeledstatement(LabeledstatementContext var1);

    void enterExpressionstatement(ExpressionstatementContext var1);

    void exitExpressionstatement(ExpressionstatementContext var1);

    void enterCompoundstatement(CompoundstatementContext var1);

    void exitCompoundstatement(CompoundstatementContext var1);

    void enterStatementseq(StatementseqContext var1);

    void exitStatementseq(StatementseqContext var1);

    void enterSelectionstatement(SelectionstatementContext var1);

    void exitSelectionstatement(SelectionstatementContext var1);

    void enterCondition(ConditionContext var1);

    void exitCondition(ConditionContext var1);

    void enterIterationstatement(IterationstatementContext var1);

    void exitIterationstatement(IterationstatementContext var1);

    void enterForinitstatement(ForinitstatementContext var1);

    void exitForinitstatement(ForinitstatementContext var1);

    void enterForrangedeclaration(ForrangedeclarationContext var1);

    void exitForrangedeclaration(ForrangedeclarationContext var1);

    void enterForrangeinitializer(ForrangeinitializerContext var1);

    void exitForrangeinitializer(ForrangeinitializerContext var1);

    void enterJumpstatement(JumpstatementContext var1);

    void exitJumpstatement(JumpstatementContext var1);

    void enterDeclarationstatement(DeclarationstatementContext var1);

    void exitDeclarationstatement(DeclarationstatementContext var1);

    void enterDeclarationseq(DeclarationseqContext var1);

    void exitDeclarationseq(DeclarationseqContext var1);

    void enterDeclaration(DeclarationContext var1);

    void exitDeclaration(DeclarationContext var1);

    void enterBlockdeclaration(BlockdeclarationContext var1);

    void exitBlockdeclaration(BlockdeclarationContext var1);

    void enterAliasdeclaration(AliasdeclarationContext var1);

    void exitAliasdeclaration(AliasdeclarationContext var1);

    void enterSimpledeclaration(SimpledeclarationContext var1);

    void exitSimpledeclaration(SimpledeclarationContext var1);

    void enterStatic_assertdeclaration(Static_assertdeclarationContext var1);

    void exitStatic_assertdeclaration(Static_assertdeclarationContext var1);

    void enterEmptydeclaration(EmptydeclarationContext var1);

    void exitEmptydeclaration(EmptydeclarationContext var1);

    void enterAttributedeclaration(AttributedeclarationContext var1);

    void exitAttributedeclaration(AttributedeclarationContext var1);

    void enterDeclspecifier(DeclspecifierContext var1);

    void exitDeclspecifier(DeclspecifierContext var1);

    void enterDeclspecifierseq(DeclspecifierseqContext var1);

    void exitDeclspecifierseq(DeclspecifierseqContext var1);

    void enterStorageclassspecifier(StorageclassspecifierContext var1);

    void exitStorageclassspecifier(StorageclassspecifierContext var1);

    void enterFunctionspecifier(FunctionspecifierContext var1);

    void exitFunctionspecifier(FunctionspecifierContext var1);

    void enterTypedefname(TypedefnameContext var1);

    void exitTypedefname(TypedefnameContext var1);

    void enterTypespecifier(TypespecifierContext var1);

    void exitTypespecifier(TypespecifierContext var1);

    void enterTrailingtypespecifier(TrailingtypespecifierContext var1);

    void exitTrailingtypespecifier(TrailingtypespecifierContext var1);

    void enterTypespecifierseq(TypespecifierseqContext var1);

    void exitTypespecifierseq(TypespecifierseqContext var1);

    void enterTrailingtypespecifierseq(TrailingtypespecifierseqContext var1);

    void exitTrailingtypespecifierseq(TrailingtypespecifierseqContext var1);

    void enterSimpletypespecifier(SimpletypespecifierContext var1);

    void exitSimpletypespecifier(SimpletypespecifierContext var1);

    void enterTypename(TypenameContext var1);

    void exitTypename(TypenameContext var1);

    void enterDecltypespecifier(DecltypespecifierContext var1);

    void exitDecltypespecifier(DecltypespecifierContext var1);

    void enterElaboratedtypespecifier(ElaboratedtypespecifierContext var1);

    void exitElaboratedtypespecifier(ElaboratedtypespecifierContext var1);

    void enterEnumname(EnumnameContext var1);

    void exitEnumname(EnumnameContext var1);

    void enterEnumspecifier(EnumspecifierContext var1);

    void exitEnumspecifier(EnumspecifierContext var1);

    void enterEnumhead(EnumheadContext var1);

    void exitEnumhead(EnumheadContext var1);

    void enterOpaqueenumdeclaration(OpaqueenumdeclarationContext var1);

    void exitOpaqueenumdeclaration(OpaqueenumdeclarationContext var1);

    void enterEnumkey(EnumkeyContext var1);

    void exitEnumkey(EnumkeyContext var1);

    void enterEnumbase(EnumbaseContext var1);

    void exitEnumbase(EnumbaseContext var1);

    void enterEnumeratorlist(EnumeratorlistContext var1);

    void exitEnumeratorlist(EnumeratorlistContext var1);

    void enterEnumeratordefinition(EnumeratordefinitionContext var1);

    void exitEnumeratordefinition(EnumeratordefinitionContext var1);

    void enterEnumerator(EnumeratorContext var1);

    void exitEnumerator(EnumeratorContext var1);

    void enterNamespacename(NamespacenameContext var1);

    void exitNamespacename(NamespacenameContext var1);

    void enterOriginalnamespacename(OriginalnamespacenameContext var1);

    void exitOriginalnamespacename(OriginalnamespacenameContext var1);

    void enterNamespacedefinition(NamespacedefinitionContext var1);

    void exitNamespacedefinition(NamespacedefinitionContext var1);

    void enterNamednamespacedefinition(NamednamespacedefinitionContext var1);

    void exitNamednamespacedefinition(NamednamespacedefinitionContext var1);

    void enterOriginalnamespacedefinition(OriginalnamespacedefinitionContext var1);

    void exitOriginalnamespacedefinition(OriginalnamespacedefinitionContext var1);

    void enterExtensionnamespacedefinition(ExtensionnamespacedefinitionContext var1);

    void exitExtensionnamespacedefinition(ExtensionnamespacedefinitionContext var1);

    void enterUnnamednamespacedefinition(UnnamednamespacedefinitionContext var1);

    void exitUnnamednamespacedefinition(UnnamednamespacedefinitionContext var1);

    void enterNamespacebody(NamespacebodyContext var1);

    void exitNamespacebody(NamespacebodyContext var1);

    void enterNamespacealias(NamespacealiasContext var1);

    void exitNamespacealias(NamespacealiasContext var1);

    void enterNamespacealiasdefinition(NamespacealiasdefinitionContext var1);

    void exitNamespacealiasdefinition(NamespacealiasdefinitionContext var1);

    void enterQualifiednamespacespecifier(QualifiednamespacespecifierContext var1);

    void exitQualifiednamespacespecifier(QualifiednamespacespecifierContext var1);

    void enterUsingdeclaration(UsingdeclarationContext var1);

    void exitUsingdeclaration(UsingdeclarationContext var1);

    void enterUsingdirective(UsingdirectiveContext var1);

    void exitUsingdirective(UsingdirectiveContext var1);

    void enterAsmdefinition(AsmdefinitionContext var1);

    void exitAsmdefinition(AsmdefinitionContext var1);

    void enterLinkagespecification(LinkagespecificationContext var1);

    void exitLinkagespecification(LinkagespecificationContext var1);

    void enterAttributespecifierseq(AttributespecifierseqContext var1);

    void exitAttributespecifierseq(AttributespecifierseqContext var1);

    void enterAttributespecifier(AttributespecifierContext var1);

    void exitAttributespecifier(AttributespecifierContext var1);

    void enterAlignmentspecifier(AlignmentspecifierContext var1);

    void exitAlignmentspecifier(AlignmentspecifierContext var1);

    void enterAttributelist(AttributelistContext var1);

    void exitAttributelist(AttributelistContext var1);

    void enterAttribute(AttributeContext var1);

    void exitAttribute(AttributeContext var1);

    void enterAttributetoken(AttributetokenContext var1);

    void exitAttributetoken(AttributetokenContext var1);

    void enterAttributescopedtoken(AttributescopedtokenContext var1);

    void exitAttributescopedtoken(AttributescopedtokenContext var1);

    void enterAttributenamespace(AttributenamespaceContext var1);

    void exitAttributenamespace(AttributenamespaceContext var1);

    void enterAttributeargumentclause(AttributeargumentclauseContext var1);

    void exitAttributeargumentclause(AttributeargumentclauseContext var1);

    void enterBalancedtokenseq(BalancedtokenseqContext var1);

    void exitBalancedtokenseq(BalancedtokenseqContext var1);

    void enterBalancedtoken(BalancedtokenContext var1);

    void exitBalancedtoken(BalancedtokenContext var1);

    void enterInitdeclaratorlist(InitdeclaratorlistContext var1);

    void exitInitdeclaratorlist(InitdeclaratorlistContext var1);

    void enterInitdeclarator(InitdeclaratorContext var1);

    void exitInitdeclarator(InitdeclaratorContext var1);

    void enterDeclarator(DeclaratorContext var1);

    void exitDeclarator(DeclaratorContext var1);

    void enterPtrdeclarator(PtrdeclaratorContext var1);

    void exitPtrdeclarator(PtrdeclaratorContext var1);

    void enterNoptrdeclarator(NoptrdeclaratorContext var1);

    void exitNoptrdeclarator(NoptrdeclaratorContext var1);

    void enterParametersandqualifiers(ParametersandqualifiersContext var1);

    void exitParametersandqualifiers(ParametersandqualifiersContext var1);

    void enterTrailingreturntype(TrailingreturntypeContext var1);

    void exitTrailingreturntype(TrailingreturntypeContext var1);

    void enterPtroperator(PtroperatorContext var1);

    void exitPtroperator(PtroperatorContext var1);

    void enterCvqualifierseq(CvqualifierseqContext var1);

    void exitCvqualifierseq(CvqualifierseqContext var1);

    void enterCvqualifier(CvqualifierContext var1);

    void exitCvqualifier(CvqualifierContext var1);

    void enterRefqualifier(RefqualifierContext var1);

    void exitRefqualifier(RefqualifierContext var1);

    void enterDeclaratorid(DeclaratoridContext var1);

    void exitDeclaratorid(DeclaratoridContext var1);

    void enterTypeid(TypeidContext var1);

    void exitTypeid(TypeidContext var1);

    void enterAbstractdeclarator(AbstractdeclaratorContext var1);

    void exitAbstractdeclarator(AbstractdeclaratorContext var1);

    void enterPtrabstractdeclarator(PtrabstractdeclaratorContext var1);

    void exitPtrabstractdeclarator(PtrabstractdeclaratorContext var1);

    void enterNoptrabstractdeclarator(NoptrabstractdeclaratorContext var1);

    void exitNoptrabstractdeclarator(NoptrabstractdeclaratorContext var1);

    void enterAbstractpackdeclarator(AbstractpackdeclaratorContext var1);

    void exitAbstractpackdeclarator(AbstractpackdeclaratorContext var1);

    void enterNoptrabstractpackdeclarator(NoptrabstractpackdeclaratorContext var1);

    void exitNoptrabstractpackdeclarator(NoptrabstractpackdeclaratorContext var1);

    void enterParameterdeclarationclause(ParameterdeclarationclauseContext var1);

    void exitParameterdeclarationclause(ParameterdeclarationclauseContext var1);

    void enterParameterdeclarationlist(ParameterdeclarationlistContext var1);

    void exitParameterdeclarationlist(ParameterdeclarationlistContext var1);

    void enterParameterdeclaration(ParameterdeclarationContext var1);

    void exitParameterdeclaration(ParameterdeclarationContext var1);

    void enterFunctiondefinition(FunctiondefinitionContext var1);

    void exitFunctiondefinition(FunctiondefinitionContext var1);

    void enterFunctionbody(FunctionbodyContext var1);

    void exitFunctionbody(FunctionbodyContext var1);

    void enterInitializer(InitializerContext var1);

    void exitInitializer(InitializerContext var1);

    void enterBraceorequalinitializer(BraceorequalinitializerContext var1);

    void exitBraceorequalinitializer(BraceorequalinitializerContext var1);

    void enterInitializerclause(InitializerclauseContext var1);

    void exitInitializerclause(InitializerclauseContext var1);

    void enterInitializerlist(InitializerlistContext var1);

    void exitInitializerlist(InitializerlistContext var1);

    void enterBracedinitlist(BracedinitlistContext var1);

    void exitBracedinitlist(BracedinitlistContext var1);

    void enterClassname(ClassnameContext var1);

    void exitClassname(ClassnameContext var1);

    void enterClassspecifier(ClassspecifierContext var1);

    void exitClassspecifier(ClassspecifierContext var1);

    void enterClasshead(ClassheadContext var1);

    void exitClasshead(ClassheadContext var1);

    void enterClassheadname(ClassheadnameContext var1);

    void exitClassheadname(ClassheadnameContext var1);

    void enterClassvirtspecifier(ClassvirtspecifierContext var1);

    void exitClassvirtspecifier(ClassvirtspecifierContext var1);

    void enterClasskey(ClasskeyContext var1);

    void exitClasskey(ClasskeyContext var1);

    void enterMemberspecification(MemberspecificationContext var1);

    void exitMemberspecification(MemberspecificationContext var1);

    void enterMemberdeclaration(MemberdeclarationContext var1);

    void exitMemberdeclaration(MemberdeclarationContext var1);

    void enterMemberdeclaratorlist(MemberdeclaratorlistContext var1);

    void exitMemberdeclaratorlist(MemberdeclaratorlistContext var1);

    void enterMemberdeclarator(MemberdeclaratorContext var1);

    void exitMemberdeclarator(MemberdeclaratorContext var1);

    void enterVirtspecifierseq(VirtspecifierseqContext var1);

    void exitVirtspecifierseq(VirtspecifierseqContext var1);

    void enterVirtspecifier(VirtspecifierContext var1);

    void exitVirtspecifier(VirtspecifierContext var1);

    void enterPurespecifier(PurespecifierContext var1);

    void exitPurespecifier(PurespecifierContext var1);

    void enterBaseclause(BaseclauseContext var1);

    void exitBaseclause(BaseclauseContext var1);

    void enterBasespecifierlist(BasespecifierlistContext var1);

    void exitBasespecifierlist(BasespecifierlistContext var1);

    void enterBasespecifier(BasespecifierContext var1);

    void exitBasespecifier(BasespecifierContext var1);

    void enterClassordecltype(ClassordecltypeContext var1);

    void exitClassordecltype(ClassordecltypeContext var1);

    void enterBasetypespecifier(BasetypespecifierContext var1);

    void exitBasetypespecifier(BasetypespecifierContext var1);

    void enterAccessspecifier(AccessspecifierContext var1);

    void exitAccessspecifier(AccessspecifierContext var1);

    void enterConversionfunctionid(ConversionfunctionidContext var1);

    void exitConversionfunctionid(ConversionfunctionidContext var1);

    void enterConversiontypeid(ConversiontypeidContext var1);

    void exitConversiontypeid(ConversiontypeidContext var1);

    void enterConversiondeclarator(ConversiondeclaratorContext var1);

    void exitConversiondeclarator(ConversiondeclaratorContext var1);

    void enterCtorinitializer(CtorinitializerContext var1);

    void exitCtorinitializer(CtorinitializerContext var1);

    void enterMeminitializerlist(MeminitializerlistContext var1);

    void exitMeminitializerlist(MeminitializerlistContext var1);

    void enterMeminitializer(MeminitializerContext var1);

    void exitMeminitializer(MeminitializerContext var1);

    void enterMeminitializerid(MeminitializeridContext var1);

    void exitMeminitializerid(MeminitializeridContext var1);

    void enterOperatorfunctionid(OperatorfunctionidContext var1);

    void exitOperatorfunctionid(OperatorfunctionidContext var1);

    void enterLiteraloperatorid(LiteraloperatoridContext var1);

    void exitLiteraloperatorid(LiteraloperatoridContext var1);

    void enterTemplatedeclaration(TemplatedeclarationContext var1);

    void exitTemplatedeclaration(TemplatedeclarationContext var1);

    void enterTemplateparameterlist(TemplateparameterlistContext var1);

    void exitTemplateparameterlist(TemplateparameterlistContext var1);

    void enterTemplateparameter(TemplateparameterContext var1);

    void exitTemplateparameter(TemplateparameterContext var1);

    void enterTypeparameter(TypeparameterContext var1);

    void exitTypeparameter(TypeparameterContext var1);

    void enterSimpletemplateid(SimpletemplateidContext var1);

    void exitSimpletemplateid(SimpletemplateidContext var1);

    void enterTemplateid(TemplateidContext var1);

    void exitTemplateid(TemplateidContext var1);

    void enterTemplatename(TemplatenameContext var1);

    void exitTemplatename(TemplatenameContext var1);

    void enterTemplateargumentlist(TemplateargumentlistContext var1);

    void exitTemplateargumentlist(TemplateargumentlistContext var1);

    void enterTemplateargument(TemplateargumentContext var1);

    void exitTemplateargument(TemplateargumentContext var1);

    void enterTypenamespecifier(TypenamespecifierContext var1);

    void exitTypenamespecifier(TypenamespecifierContext var1);

    void enterExplicitinstantiation(ExplicitinstantiationContext var1);

    void exitExplicitinstantiation(ExplicitinstantiationContext var1);

    void enterExplicitspecialization(ExplicitspecializationContext var1);

    void exitExplicitspecialization(ExplicitspecializationContext var1);

    void enterTryblock(TryblockContext var1);

    void exitTryblock(TryblockContext var1);

    void enterFunctiontryblock(FunctiontryblockContext var1);

    void exitFunctiontryblock(FunctiontryblockContext var1);

    void enterHandlerseq(HandlerseqContext var1);

    void exitHandlerseq(HandlerseqContext var1);

    void enterHandler(HandlerContext var1);

    void exitHandler(HandlerContext var1);

    void enterExceptiondeclaration(ExceptiondeclarationContext var1);

    void exitExceptiondeclaration(ExceptiondeclarationContext var1);

    void enterThrowexpression(ThrowexpressionContext var1);

    void exitThrowexpression(ThrowexpressionContext var1);

    void enterExceptionspecification(ExceptionspecificationContext var1);

    void exitExceptionspecification(ExceptionspecificationContext var1);

    void enterDynamicexceptionspecification(DynamicexceptionspecificationContext var1);

    void exitDynamicexceptionspecification(DynamicexceptionspecificationContext var1);

    void enterTypeidlist(TypeidlistContext var1);

    void exitTypeidlist(TypeidlistContext var1);

    void enterNoexceptspecification(NoexceptspecificationContext var1);

    void exitNoexceptspecification(NoexceptspecificationContext var1);

    void enterRightShift(RightShiftContext var1);

    void exitRightShift(RightShiftContext var1);

    void enterRightShiftAssign(RightShiftAssignContext var1);

    void exitRightShiftAssign(RightShiftAssignContext var1);

    void enterOperator(OperatorContext var1);

    void exitOperator(OperatorContext var1);

    void enterLiteral(LiteralContext var1);

    void exitLiteral(LiteralContext var1);

    void enterBooleanliteral(BooleanliteralContext var1);

    void exitBooleanliteral(BooleanliteralContext var1);

    void enterPointerliteral(PointerliteralContext var1);

    void exitPointerliteral(PointerliteralContext var1);

    void enterUserdefinedliteral(UserdefinedliteralContext var1);

    void exitUserdefinedliteral(UserdefinedliteralContext var1);
}
