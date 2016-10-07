package metrics;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import metrics.CPP14Parser.*;
/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class CPP14BaseListener implements CPP14Listener {
    public CPP14BaseListener() {
    }

    public void enterTranslationunit(TranslationunitContext ctx) {
    }

    public void exitTranslationunit(TranslationunitContext ctx) {
    }

    public void enterPrimaryexpression(PrimaryexpressionContext ctx) {
    }

    public void exitPrimaryexpression(PrimaryexpressionContext ctx) {
    }

    public void enterIdexpression(IdexpressionContext ctx) {
    }

    public void exitIdexpression(IdexpressionContext ctx) {
    }

    public void enterUnqualifiedid(UnqualifiedidContext ctx) {
    }

    public void exitUnqualifiedid(UnqualifiedidContext ctx) {
    }

    public void enterQualifiedid(QualifiedidContext ctx) {
    }

    public void exitQualifiedid(QualifiedidContext ctx) {
    }

    public void enterNestednamespecifier(NestednamespecifierContext ctx) {
    }

    public void exitNestednamespecifier(NestednamespecifierContext ctx) {
    }

    public void enterLambdaexpression(LambdaexpressionContext ctx) {
    }

    public void exitLambdaexpression(LambdaexpressionContext ctx) {
    }

    public void enterLambdaintroducer(LambdaintroducerContext ctx) {
    }

    public void exitLambdaintroducer(LambdaintroducerContext ctx) {
    }

    public void enterLambdacapture(LambdacaptureContext ctx) {
    }

    public void exitLambdacapture(LambdacaptureContext ctx) {
    }

    public void enterCapturedefault(CapturedefaultContext ctx) {
    }

    public void exitCapturedefault(CapturedefaultContext ctx) {
    }

    public void enterCapturelist(CapturelistContext ctx) {
    }

    public void exitCapturelist(CapturelistContext ctx) {
    }

    public void enterCapture(CaptureContext ctx) {
    }

    public void exitCapture(CaptureContext ctx) {
    }

    public void enterSimplecapture(SimplecaptureContext ctx) {
    }

    public void exitSimplecapture(SimplecaptureContext ctx) {
    }

    public void enterInitcapture(InitcaptureContext ctx) {
    }

    public void exitInitcapture(InitcaptureContext ctx) {
    }

    public void enterLambdadeclarator(LambdadeclaratorContext ctx) {
    }

    public void exitLambdadeclarator(LambdadeclaratorContext ctx) {
    }

    public void enterPostfixexpression(PostfixexpressionContext ctx) {
    }

    public void exitPostfixexpression(PostfixexpressionContext ctx) {
    }

    public void enterExpressionlist(ExpressionlistContext ctx) {
    }

    public void exitExpressionlist(ExpressionlistContext ctx) {
    }

    public void enterPseudodestructorname(PseudodestructornameContext ctx) {
    }

    public void exitPseudodestructorname(PseudodestructornameContext ctx) {
    }

    public void enterUnaryexpression(UnaryexpressionContext ctx) {
    }

    public void exitUnaryexpression(UnaryexpressionContext ctx) {
    }

    public void enterUnaryoperator(UnaryoperatorContext ctx) {
    }

    public void exitUnaryoperator(UnaryoperatorContext ctx) {
    }

    public void enterNewexpression(NewexpressionContext ctx) {
    }

    public void exitNewexpression(NewexpressionContext ctx) {
    }

    public void enterNewplacement(NewplacementContext ctx) {
    }

    public void exitNewplacement(NewplacementContext ctx) {
    }

    public void enterNewtypeid(NewtypeidContext ctx) {
    }

    public void exitNewtypeid(NewtypeidContext ctx) {
    }

    public void enterNewdeclarator(NewdeclaratorContext ctx) {
    }

    public void exitNewdeclarator(NewdeclaratorContext ctx) {
    }

    public void enterNoptrnewdeclarator(NoptrnewdeclaratorContext ctx) {
    }

    public void exitNoptrnewdeclarator(NoptrnewdeclaratorContext ctx) {
    }

    public void enterNewinitializer(NewinitializerContext ctx) {
    }

    public void exitNewinitializer(NewinitializerContext ctx) {
    }

    public void enterDeleteexpression(DeleteexpressionContext ctx) {
    }

    public void exitDeleteexpression(DeleteexpressionContext ctx) {
    }

    public void enterNoexceptexpression(NoexceptexpressionContext ctx) {
    }

    public void exitNoexceptexpression(NoexceptexpressionContext ctx) {
    }

    public void enterCastexpression(CastexpressionContext ctx) {
    }

    public void exitCastexpression(CastexpressionContext ctx) {
    }

    public void enterPmexpression(PmexpressionContext ctx) {
    }

    public void exitPmexpression(PmexpressionContext ctx) {
    }

    public void enterMultiplicativeexpression(MultiplicativeexpressionContext ctx) {
    }

    public void exitMultiplicativeexpression(MultiplicativeexpressionContext ctx) {
    }

    public void enterAdditiveexpression(AdditiveexpressionContext ctx) {
    }

    public void exitAdditiveexpression(AdditiveexpressionContext ctx) {
    }

    public void enterShiftexpression(ShiftexpressionContext ctx) {
    }

    public void exitShiftexpression(ShiftexpressionContext ctx) {
    }

    public void enterRelationalexpression(RelationalexpressionContext ctx) {
    }

    public void exitRelationalexpression(RelationalexpressionContext ctx) {
    }

    public void enterEqualityexpression(EqualityexpressionContext ctx) {
    }

    public void exitEqualityexpression(EqualityexpressionContext ctx) {
    }

    public void enterAndexpression(AndexpressionContext ctx) {
    }

    public void exitAndexpression(AndexpressionContext ctx) {
    }

    public void enterExclusiveorexpression(ExclusiveorexpressionContext ctx) {
    }

    public void exitExclusiveorexpression(ExclusiveorexpressionContext ctx) {
    }

    public void enterInclusiveorexpression(InclusiveorexpressionContext ctx) {
    }

    public void exitInclusiveorexpression(InclusiveorexpressionContext ctx) {
    }

    public void enterLogicalandexpression(LogicalandexpressionContext ctx) {
    }

    public void exitLogicalandexpression(LogicalandexpressionContext ctx) {
    }

    public void enterLogicalorexpression(LogicalorexpressionContext ctx) {
    }

    public void exitLogicalorexpression(LogicalorexpressionContext ctx) {
    }

    public void enterConditionalexpression(ConditionalexpressionContext ctx) {
    }

    public void exitConditionalexpression(ConditionalexpressionContext ctx) {
    }

    public void enterAssignmentexpression(AssignmentexpressionContext ctx) {
    }

    public void exitAssignmentexpression(AssignmentexpressionContext ctx) {
    }

    public void enterAssignmentoperator(AssignmentoperatorContext ctx) {
    }

    public void exitAssignmentoperator(AssignmentoperatorContext ctx) {
    }

    public void enterExpression(ExpressionContext ctx) {
    }

    public void exitExpression(ExpressionContext ctx) {
    }

    public void enterConstantexpression(ConstantexpressionContext ctx) {
    }

    public void exitConstantexpression(ConstantexpressionContext ctx) {
    }

    public void enterStatement(StatementContext ctx) {
    }

    public void exitStatement(StatementContext ctx) {
    }

    public void enterLabeledstatement(LabeledstatementContext ctx) {
    }

    public void exitLabeledstatement(LabeledstatementContext ctx) {
    }

    public void enterExpressionstatement(ExpressionstatementContext ctx) {
    }

    public void exitExpressionstatement(ExpressionstatementContext ctx) {
    }

    public void enterCompoundstatement(CompoundstatementContext ctx) {
    }

    public void exitCompoundstatement(CompoundstatementContext ctx) {
    }

    public void enterStatementseq(StatementseqContext ctx) {
    }

    public void exitStatementseq(StatementseqContext ctx) {
    }

    public void enterSelectionstatement(SelectionstatementContext ctx) {
    }

    public void exitSelectionstatement(SelectionstatementContext ctx) {
    }

    public void enterCondition(ConditionContext ctx) {
    }

    public void exitCondition(ConditionContext ctx) {
    }

    public void enterIterationstatement(IterationstatementContext ctx) {
    }

    public void exitIterationstatement(IterationstatementContext ctx) {
    }

    public void enterForinitstatement(ForinitstatementContext ctx) {
    }

    public void exitForinitstatement(ForinitstatementContext ctx) {
    }

    public void enterForrangedeclaration(ForrangedeclarationContext ctx) {
    }

    public void exitForrangedeclaration(ForrangedeclarationContext ctx) {
    }

    public void enterForrangeinitializer(ForrangeinitializerContext ctx) {
    }

    public void exitForrangeinitializer(ForrangeinitializerContext ctx) {
    }

    public void enterJumpstatement(JumpstatementContext ctx) {
    }

    public void exitJumpstatement(JumpstatementContext ctx) {
    }

    public void enterDeclarationstatement(DeclarationstatementContext ctx) {
    }

    public void exitDeclarationstatement(DeclarationstatementContext ctx) {
    }

    public void enterDeclarationseq(DeclarationseqContext ctx) {
    }

    public void exitDeclarationseq(DeclarationseqContext ctx) {
    }

    public void enterDeclaration(DeclarationContext ctx) {
    }

    public void exitDeclaration(DeclarationContext ctx) {
    }

    public void enterBlockdeclaration(BlockdeclarationContext ctx) {
    }

    public void exitBlockdeclaration(BlockdeclarationContext ctx) {
    }

    public void enterAliasdeclaration(AliasdeclarationContext ctx) {
    }

    public void exitAliasdeclaration(AliasdeclarationContext ctx) {
    }

    public void enterSimpledeclaration(SimpledeclarationContext ctx) {
    }

    public void exitSimpledeclaration(SimpledeclarationContext ctx) {
    }

    public void enterStatic_assertdeclaration(Static_assertdeclarationContext ctx) {
    }

    public void exitStatic_assertdeclaration(Static_assertdeclarationContext ctx) {
    }

    public void enterEmptydeclaration(EmptydeclarationContext ctx) {
    }

    public void exitEmptydeclaration(EmptydeclarationContext ctx) {
    }

    public void enterAttributedeclaration(AttributedeclarationContext ctx) {
    }

    public void exitAttributedeclaration(AttributedeclarationContext ctx) {
    }

    public void enterDeclspecifier(DeclspecifierContext ctx) {
    }

    public void exitDeclspecifier(DeclspecifierContext ctx) {
    }

    public void enterDeclspecifierseq(DeclspecifierseqContext ctx) {
    }

    public void exitDeclspecifierseq(DeclspecifierseqContext ctx) {
    }

    public void enterStorageclassspecifier(StorageclassspecifierContext ctx) {
    }

    public void exitStorageclassspecifier(StorageclassspecifierContext ctx) {
    }

    public void enterFunctionspecifier(FunctionspecifierContext ctx) {
    }

    public void exitFunctionspecifier(FunctionspecifierContext ctx) {
    }

    public void enterTypedefname(TypedefnameContext ctx) {
    }

    public void exitTypedefname(TypedefnameContext ctx) {
    }

    public void enterTypespecifier(TypespecifierContext ctx) {
    }

    public void exitTypespecifier(TypespecifierContext ctx) {
    }

    public void enterTrailingtypespecifier(TrailingtypespecifierContext ctx) {
    }

    public void exitTrailingtypespecifier(TrailingtypespecifierContext ctx) {
    }

    public void enterTypespecifierseq(TypespecifierseqContext ctx) {
    }

    public void exitTypespecifierseq(TypespecifierseqContext ctx) {
    }

    public void enterTrailingtypespecifierseq(TrailingtypespecifierseqContext ctx) {
    }

    public void exitTrailingtypespecifierseq(TrailingtypespecifierseqContext ctx) {
    }

    public void enterSimpletypespecifier(SimpletypespecifierContext ctx) {
    }

    public void exitSimpletypespecifier(SimpletypespecifierContext ctx) {
    }

    public void enterTypename(TypenameContext ctx) {
    }

    public void exitTypename(TypenameContext ctx) {
    }

    public void enterDecltypespecifier(DecltypespecifierContext ctx) {
    }

    public void exitDecltypespecifier(DecltypespecifierContext ctx) {
    }

    public void enterElaboratedtypespecifier(ElaboratedtypespecifierContext ctx) {
    }

    public void exitElaboratedtypespecifier(ElaboratedtypespecifierContext ctx) {
    }

    public void enterEnumname(EnumnameContext ctx) {
    }

    public void exitEnumname(EnumnameContext ctx) {
    }

    public void enterEnumspecifier(EnumspecifierContext ctx) {
    }

    public void exitEnumspecifier(EnumspecifierContext ctx) {
    }

    public void enterEnumhead(EnumheadContext ctx) {
    }

    public void exitEnumhead(EnumheadContext ctx) {
    }

    public void enterOpaqueenumdeclaration(OpaqueenumdeclarationContext ctx) {
    }

    public void exitOpaqueenumdeclaration(OpaqueenumdeclarationContext ctx) {
    }

    public void enterEnumkey(EnumkeyContext ctx) {
    }

    public void exitEnumkey(EnumkeyContext ctx) {
    }

    public void enterEnumbase(EnumbaseContext ctx) {
    }

    public void exitEnumbase(EnumbaseContext ctx) {
    }

    public void enterEnumeratorlist(EnumeratorlistContext ctx) {
    }

    public void exitEnumeratorlist(EnumeratorlistContext ctx) {
    }

    public void enterEnumeratordefinition(EnumeratordefinitionContext ctx) {
    }

    public void exitEnumeratordefinition(EnumeratordefinitionContext ctx) {
    }

    public void enterEnumerator(EnumeratorContext ctx) {
    }

    public void exitEnumerator(EnumeratorContext ctx) {
    }

    public void enterNamespacename(NamespacenameContext ctx) {
    }

    public void exitNamespacename(NamespacenameContext ctx) {
    }

    public void enterOriginalnamespacename(OriginalnamespacenameContext ctx) {
    }

    public void exitOriginalnamespacename(OriginalnamespacenameContext ctx) {
    }

    public void enterNamespacedefinition(NamespacedefinitionContext ctx) {
    }

    public void exitNamespacedefinition(NamespacedefinitionContext ctx) {
    }

    public void enterNamednamespacedefinition(NamednamespacedefinitionContext ctx) {
    }

    public void exitNamednamespacedefinition(NamednamespacedefinitionContext ctx) {
    }

    public void enterOriginalnamespacedefinition(OriginalnamespacedefinitionContext ctx) {
    }

    public void exitOriginalnamespacedefinition(OriginalnamespacedefinitionContext ctx) {
    }

    public void enterExtensionnamespacedefinition(ExtensionnamespacedefinitionContext ctx) {
    }

    public void exitExtensionnamespacedefinition(ExtensionnamespacedefinitionContext ctx) {
    }

    public void enterUnnamednamespacedefinition(UnnamednamespacedefinitionContext ctx) {
    }

    public void exitUnnamednamespacedefinition(UnnamednamespacedefinitionContext ctx) {
    }

    public void enterNamespacebody(NamespacebodyContext ctx) {
    }

    public void exitNamespacebody(NamespacebodyContext ctx) {
    }

    public void enterNamespacealias(NamespacealiasContext ctx) {
    }

    public void exitNamespacealias(NamespacealiasContext ctx) {
    }

    public void enterNamespacealiasdefinition(NamespacealiasdefinitionContext ctx) {
    }

    public void exitNamespacealiasdefinition(NamespacealiasdefinitionContext ctx) {
    }

    public void enterQualifiednamespacespecifier(QualifiednamespacespecifierContext ctx) {
    }

    public void exitQualifiednamespacespecifier(QualifiednamespacespecifierContext ctx) {
    }

    public void enterUsingdeclaration(UsingdeclarationContext ctx) {
    }

    public void exitUsingdeclaration(UsingdeclarationContext ctx) {
    }

    public void enterUsingdirective(UsingdirectiveContext ctx) {
    }

    public void exitUsingdirective(UsingdirectiveContext ctx) {
    }

    public void enterAsmdefinition(AsmdefinitionContext ctx) {
    }

    public void exitAsmdefinition(AsmdefinitionContext ctx) {
    }

    public void enterLinkagespecification(LinkagespecificationContext ctx) {
    }

    public void exitLinkagespecification(LinkagespecificationContext ctx) {
    }

    public void enterAttributespecifierseq(AttributespecifierseqContext ctx) {
    }

    public void exitAttributespecifierseq(AttributespecifierseqContext ctx) {
    }

    public void enterAttributespecifier(AttributespecifierContext ctx) {
    }

    public void exitAttributespecifier(AttributespecifierContext ctx) {
    }

    public void enterAlignmentspecifier(AlignmentspecifierContext ctx) {
    }

    public void exitAlignmentspecifier(AlignmentspecifierContext ctx) {
    }

    public void enterAttributelist(AttributelistContext ctx) {
    }

    public void exitAttributelist(AttributelistContext ctx) {
    }

    public void enterAttribute(AttributeContext ctx) {
    }

    public void exitAttribute(AttributeContext ctx) {
    }

    public void enterAttributetoken(AttributetokenContext ctx) {
    }

    public void exitAttributetoken(AttributetokenContext ctx) {
    }

    public void enterAttributescopedtoken(AttributescopedtokenContext ctx) {
    }

    public void exitAttributescopedtoken(AttributescopedtokenContext ctx) {
    }

    public void enterAttributenamespace(AttributenamespaceContext ctx) {
    }

    public void exitAttributenamespace(AttributenamespaceContext ctx) {
    }

    public void enterAttributeargumentclause(AttributeargumentclauseContext ctx) {
    }

    public void exitAttributeargumentclause(AttributeargumentclauseContext ctx) {
    }

    public void enterBalancedtokenseq(BalancedtokenseqContext ctx) {
    }

    public void exitBalancedtokenseq(BalancedtokenseqContext ctx) {
    }

    public void enterBalancedtoken(BalancedtokenContext ctx) {
    }

    public void exitBalancedtoken(BalancedtokenContext ctx) {
    }

    public void enterInitdeclaratorlist(InitdeclaratorlistContext ctx) {
    }

    public void exitInitdeclaratorlist(InitdeclaratorlistContext ctx) {
    }

    public void enterInitdeclarator(InitdeclaratorContext ctx) {
    }

    public void exitInitdeclarator(InitdeclaratorContext ctx) {
    }

    public void enterDeclarator(DeclaratorContext ctx) {
    }

    public void exitDeclarator(DeclaratorContext ctx) {
    }

    public void enterPtrdeclarator(PtrdeclaratorContext ctx) {
    }

    public void exitPtrdeclarator(PtrdeclaratorContext ctx) {
    }

    public void enterNoptrdeclarator(NoptrdeclaratorContext ctx) {
    }

    public void exitNoptrdeclarator(NoptrdeclaratorContext ctx) {
    }

    public void enterParametersandqualifiers(ParametersandqualifiersContext ctx) {
    }

    public void exitParametersandqualifiers(ParametersandqualifiersContext ctx) {
    }

    public void enterTrailingreturntype(TrailingreturntypeContext ctx) {
    }

    public void exitTrailingreturntype(TrailingreturntypeContext ctx) {
    }

    public void enterPtroperator(PtroperatorContext ctx) {
    }

    public void exitPtroperator(PtroperatorContext ctx) {
    }

    public void enterCvqualifierseq(CvqualifierseqContext ctx) {
    }

    public void exitCvqualifierseq(CvqualifierseqContext ctx) {
    }

    public void enterCvqualifier(CvqualifierContext ctx) {
    }

    public void exitCvqualifier(CvqualifierContext ctx) {
    }

    public void enterRefqualifier(RefqualifierContext ctx) {
    }

    public void exitRefqualifier(RefqualifierContext ctx) {
    }

    public void enterDeclaratorid(DeclaratoridContext ctx) {
    }

    public void exitDeclaratorid(DeclaratoridContext ctx) {
    }

    public void enterTypeid(TypeidContext ctx) {
    }

    public void exitTypeid(TypeidContext ctx) {
    }

    public void enterAbstractdeclarator(AbstractdeclaratorContext ctx) {
    }

    public void exitAbstractdeclarator(AbstractdeclaratorContext ctx) {
    }

    public void enterPtrabstractdeclarator(PtrabstractdeclaratorContext ctx) {
    }

    public void exitPtrabstractdeclarator(PtrabstractdeclaratorContext ctx) {
    }

    public void enterNoptrabstractdeclarator(NoptrabstractdeclaratorContext ctx) {
    }

    public void exitNoptrabstractdeclarator(NoptrabstractdeclaratorContext ctx) {
    }

    public void enterAbstractpackdeclarator(AbstractpackdeclaratorContext ctx) {
    }

    public void exitAbstractpackdeclarator(AbstractpackdeclaratorContext ctx) {
    }

    public void enterNoptrabstractpackdeclarator(NoptrabstractpackdeclaratorContext ctx) {
    }

    public void exitNoptrabstractpackdeclarator(NoptrabstractpackdeclaratorContext ctx) {
    }

    public void enterParameterdeclarationclause(ParameterdeclarationclauseContext ctx) {
    }

    public void exitParameterdeclarationclause(ParameterdeclarationclauseContext ctx) {
    }

    public void enterParameterdeclarationlist(ParameterdeclarationlistContext ctx) {
    }

    public void exitParameterdeclarationlist(ParameterdeclarationlistContext ctx) {
    }

    public void enterParameterdeclaration(ParameterdeclarationContext ctx) {
    }

    public void exitParameterdeclaration(ParameterdeclarationContext ctx) {
    }

    public void enterFunctiondefinition(FunctiondefinitionContext ctx) {
    }

    public void exitFunctiondefinition(FunctiondefinitionContext ctx) {
    }

    public void enterFunctionbody(FunctionbodyContext ctx) {
    }

    public void exitFunctionbody(FunctionbodyContext ctx) {
    }

    public void enterInitializer(InitializerContext ctx) {
    }

    public void exitInitializer(InitializerContext ctx) {
    }

    public void enterBraceorequalinitializer(BraceorequalinitializerContext ctx) {
    }

    public void exitBraceorequalinitializer(BraceorequalinitializerContext ctx) {
    }

    public void enterInitializerclause(InitializerclauseContext ctx) {
    }

    public void exitInitializerclause(InitializerclauseContext ctx) {
    }

    public void enterInitializerlist(InitializerlistContext ctx) {
    }

    public void exitInitializerlist(InitializerlistContext ctx) {
    }

    public void enterBracedinitlist(BracedinitlistContext ctx) {
    }

    public void exitBracedinitlist(BracedinitlistContext ctx) {
    }

    public void enterClassname(ClassnameContext ctx) {
    }

    public void exitClassname(ClassnameContext ctx) {
    }

    public void enterClassspecifier(ClassspecifierContext ctx) {
    }

    public void exitClassspecifier(ClassspecifierContext ctx) {
    }

    public void enterClasshead(ClassheadContext ctx) {
    }

    public void exitClasshead(ClassheadContext ctx) {
    }

    public void enterClassheadname(ClassheadnameContext ctx) {
    }

    public void exitClassheadname(ClassheadnameContext ctx) {
    }

    public void enterClassvirtspecifier(ClassvirtspecifierContext ctx) {
    }

    public void exitClassvirtspecifier(ClassvirtspecifierContext ctx) {
    }

    public void enterClasskey(ClasskeyContext ctx) {
    }

    public void exitClasskey(ClasskeyContext ctx) {
    }

    public void enterMemberspecification(MemberspecificationContext ctx) {
    }

    public void exitMemberspecification(MemberspecificationContext ctx) {
    }

    public void enterMemberdeclaration(MemberdeclarationContext ctx) {
    }

    public void exitMemberdeclaration(MemberdeclarationContext ctx) {
    }

    public void enterMemberdeclaratorlist(MemberdeclaratorlistContext ctx) {
    }

    public void exitMemberdeclaratorlist(MemberdeclaratorlistContext ctx) {
    }

    public void enterMemberdeclarator(MemberdeclaratorContext ctx) {
    }

    public void exitMemberdeclarator(MemberdeclaratorContext ctx) {
    }

    public void enterVirtspecifierseq(VirtspecifierseqContext ctx) {
    }

    public void exitVirtspecifierseq(VirtspecifierseqContext ctx) {
    }

    public void enterVirtspecifier(VirtspecifierContext ctx) {
    }

    public void exitVirtspecifier(VirtspecifierContext ctx) {
    }

    public void enterPurespecifier(PurespecifierContext ctx) {
    }

    public void exitPurespecifier(PurespecifierContext ctx) {
    }

    public void enterBaseclause(BaseclauseContext ctx) {
    }

    public void exitBaseclause(BaseclauseContext ctx) {
    }

    public void enterBasespecifierlist(BasespecifierlistContext ctx) {
    }

    public void exitBasespecifierlist(BasespecifierlistContext ctx) {
    }

    public void enterBasespecifier(BasespecifierContext ctx) {
    }

    public void exitBasespecifier(BasespecifierContext ctx) {
    }

    public void enterClassordecltype(ClassordecltypeContext ctx) {
    }

    public void exitClassordecltype(ClassordecltypeContext ctx) {
    }

    public void enterBasetypespecifier(BasetypespecifierContext ctx) {
    }

    public void exitBasetypespecifier(BasetypespecifierContext ctx) {
    }

    public void enterAccessspecifier(AccessspecifierContext ctx) {
    }

    public void exitAccessspecifier(AccessspecifierContext ctx) {
    }

    public void enterConversionfunctionid(ConversionfunctionidContext ctx) {
    }

    public void exitConversionfunctionid(ConversionfunctionidContext ctx) {
    }

    public void enterConversiontypeid(ConversiontypeidContext ctx) {
    }

    public void exitConversiontypeid(ConversiontypeidContext ctx) {
    }

    public void enterConversiondeclarator(ConversiondeclaratorContext ctx) {
    }

    public void exitConversiondeclarator(ConversiondeclaratorContext ctx) {
    }

    public void enterCtorinitializer(CtorinitializerContext ctx) {
    }

    public void exitCtorinitializer(CtorinitializerContext ctx) {
    }

    public void enterMeminitializerlist(MeminitializerlistContext ctx) {
    }

    public void exitMeminitializerlist(MeminitializerlistContext ctx) {
    }

    public void enterMeminitializer(MeminitializerContext ctx) {
    }

    public void exitMeminitializer(MeminitializerContext ctx) {
    }

    public void enterMeminitializerid(MeminitializeridContext ctx) {
    }

    public void exitMeminitializerid(MeminitializeridContext ctx) {
    }

    public void enterOperatorfunctionid(OperatorfunctionidContext ctx) {
    }

    public void exitOperatorfunctionid(OperatorfunctionidContext ctx) {
    }

    public void enterLiteraloperatorid(LiteraloperatoridContext ctx) {
    }

    public void exitLiteraloperatorid(LiteraloperatoridContext ctx) {
    }

    public void enterTemplatedeclaration(TemplatedeclarationContext ctx) {
    }

    public void exitTemplatedeclaration(TemplatedeclarationContext ctx) {
    }

    public void enterTemplateparameterlist(TemplateparameterlistContext ctx) {
    }

    public void exitTemplateparameterlist(TemplateparameterlistContext ctx) {
    }

    public void enterTemplateparameter(TemplateparameterContext ctx) {
    }

    public void exitTemplateparameter(TemplateparameterContext ctx) {
    }

    public void enterTypeparameter(TypeparameterContext ctx) {
    }

    public void exitTypeparameter(TypeparameterContext ctx) {
    }

    public void enterSimpletemplateid(SimpletemplateidContext ctx) {
    }

    public void exitSimpletemplateid(SimpletemplateidContext ctx) {
    }

    public void enterTemplateid(TemplateidContext ctx) {
    }

    public void exitTemplateid(TemplateidContext ctx) {
    }

    public void enterTemplatename(TemplatenameContext ctx) {
    }

    public void exitTemplatename(TemplatenameContext ctx) {
    }

    public void enterTemplateargumentlist(TemplateargumentlistContext ctx) {
    }

    public void exitTemplateargumentlist(TemplateargumentlistContext ctx) {
    }

    public void enterTemplateargument(TemplateargumentContext ctx) {
    }

    public void exitTemplateargument(TemplateargumentContext ctx) {
    }

    public void enterTypenamespecifier(TypenamespecifierContext ctx) {
    }

    public void exitTypenamespecifier(TypenamespecifierContext ctx) {
    }

    public void enterExplicitinstantiation(ExplicitinstantiationContext ctx) {
    }

    public void exitExplicitinstantiation(ExplicitinstantiationContext ctx) {
    }

    public void enterExplicitspecialization(ExplicitspecializationContext ctx) {
    }

    public void exitExplicitspecialization(ExplicitspecializationContext ctx) {
    }

    public void enterTryblock(TryblockContext ctx) {
    }

    public void exitTryblock(TryblockContext ctx) {
    }

    public void enterFunctiontryblock(FunctiontryblockContext ctx) {
    }

    public void exitFunctiontryblock(FunctiontryblockContext ctx) {
    }

    public void enterHandlerseq(HandlerseqContext ctx) {
    }

    public void exitHandlerseq(HandlerseqContext ctx) {
    }

    public void enterHandler(HandlerContext ctx) {
    }

    public void exitHandler(HandlerContext ctx) {
    }

    public void enterExceptiondeclaration(ExceptiondeclarationContext ctx) {
    }

    public void exitExceptiondeclaration(ExceptiondeclarationContext ctx) {
    }

    public void enterThrowexpression(ThrowexpressionContext ctx) {
    }

    public void exitThrowexpression(ThrowexpressionContext ctx) {
    }

    public void enterExceptionspecification(ExceptionspecificationContext ctx) {
    }

    public void exitExceptionspecification(ExceptionspecificationContext ctx) {
    }

    public void enterDynamicexceptionspecification(DynamicexceptionspecificationContext ctx) {
    }

    public void exitDynamicexceptionspecification(DynamicexceptionspecificationContext ctx) {
    }

    public void enterTypeidlist(TypeidlistContext ctx) {
    }

    public void exitTypeidlist(TypeidlistContext ctx) {
    }

    public void enterNoexceptspecification(NoexceptspecificationContext ctx) {
    }

    public void exitNoexceptspecification(NoexceptspecificationContext ctx) {
    }

    public void enterRightShift(RightShiftContext ctx) {
    }

    public void exitRightShift(RightShiftContext ctx) {
    }

    public void enterRightShiftAssign(RightShiftAssignContext ctx) {
    }

    public void exitRightShiftAssign(RightShiftAssignContext ctx) {
    }

    public void enterOperator(OperatorContext ctx) {
    }

    public void exitOperator(OperatorContext ctx) {
    }

    public void enterLiteral(LiteralContext ctx) {
    }

    public void exitLiteral(LiteralContext ctx) {
    }

    public void enterBooleanliteral(BooleanliteralContext ctx) {
    }

    public void exitBooleanliteral(BooleanliteralContext ctx) {
    }

    public void enterPointerliteral(PointerliteralContext ctx) {
    }

    public void exitPointerliteral(PointerliteralContext ctx) {
    }

    public void enterUserdefinedliteral(UserdefinedliteralContext ctx) {
    }

    public void exitUserdefinedliteral(UserdefinedliteralContext ctx) {
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
