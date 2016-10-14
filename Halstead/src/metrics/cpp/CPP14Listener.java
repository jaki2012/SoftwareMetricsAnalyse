package metrics.cpp;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public interface CPP14Listener extends ParseTreeListener {
    void enterTranslationunit(CPP14Parser.TranslationunitContext var1);

    void exitTranslationunit(CPP14Parser.TranslationunitContext var1);

    void enterPrimaryexpression(CPP14Parser.PrimaryexpressionContext var1);

    void exitPrimaryexpression(CPP14Parser.PrimaryexpressionContext var1);

    void enterIdexpression(CPP14Parser.IdexpressionContext var1);

    void exitIdexpression(CPP14Parser.IdexpressionContext var1);

    void enterUnqualifiedid(CPP14Parser.UnqualifiedidContext var1);

    void exitUnqualifiedid(CPP14Parser.UnqualifiedidContext var1);

    void enterQualifiedid(CPP14Parser.QualifiedidContext var1);

    void exitQualifiedid(CPP14Parser.QualifiedidContext var1);

    void enterNestednamespecifier(CPP14Parser.NestednamespecifierContext var1);

    void exitNestednamespecifier(CPP14Parser.NestednamespecifierContext var1);

    void enterLambdaexpression(CPP14Parser.LambdaexpressionContext var1);

    void exitLambdaexpression(CPP14Parser.LambdaexpressionContext var1);

    void enterLambdaintroducer(CPP14Parser.LambdaintroducerContext var1);

    void exitLambdaintroducer(CPP14Parser.LambdaintroducerContext var1);

    void enterLambdacapture(CPP14Parser.LambdacaptureContext var1);

    void exitLambdacapture(CPP14Parser.LambdacaptureContext var1);

    void enterCapturedefault(CPP14Parser.CapturedefaultContext var1);

    void exitCapturedefault(CPP14Parser.CapturedefaultContext var1);

    void enterCapturelist(CPP14Parser.CapturelistContext var1);

    void exitCapturelist(CPP14Parser.CapturelistContext var1);

    void enterCapture(CPP14Parser.CaptureContext var1);

    void exitCapture(CPP14Parser.CaptureContext var1);

    void enterSimplecapture(CPP14Parser.SimplecaptureContext var1);

    void exitSimplecapture(CPP14Parser.SimplecaptureContext var1);

    void enterInitcapture(CPP14Parser.InitcaptureContext var1);

    void exitInitcapture(CPP14Parser.InitcaptureContext var1);

    void enterLambdadeclarator(CPP14Parser.LambdadeclaratorContext var1);

    void exitLambdadeclarator(CPP14Parser.LambdadeclaratorContext var1);

    void enterPostfixexpression(CPP14Parser.PostfixexpressionContext var1);

    void exitPostfixexpression(CPP14Parser.PostfixexpressionContext var1);

    void enterExpressionlist(CPP14Parser.ExpressionlistContext var1);

    void exitExpressionlist(CPP14Parser.ExpressionlistContext var1);

    void enterPseudodestructorname(CPP14Parser.PseudodestructornameContext var1);

    void exitPseudodestructorname(CPP14Parser.PseudodestructornameContext var1);

    void enterUnaryexpression(CPP14Parser.UnaryexpressionContext var1);

    void exitUnaryexpression(CPP14Parser.UnaryexpressionContext var1);

    void enterUnaryoperator(CPP14Parser.UnaryoperatorContext var1);

    void exitUnaryoperator(CPP14Parser.UnaryoperatorContext var1);

    void enterNewexpression(CPP14Parser.NewexpressionContext var1);

    void exitNewexpression(CPP14Parser.NewexpressionContext var1);

    void enterNewplacement(CPP14Parser.NewplacementContext var1);

    void exitNewplacement(CPP14Parser.NewplacementContext var1);

    void enterNewtypeid(CPP14Parser.NewtypeidContext var1);

    void exitNewtypeid(CPP14Parser.NewtypeidContext var1);

    void enterNewdeclarator(CPP14Parser.NewdeclaratorContext var1);

    void exitNewdeclarator(CPP14Parser.NewdeclaratorContext var1);

    void enterNoptrnewdeclarator(CPP14Parser.NoptrnewdeclaratorContext var1);

    void exitNoptrnewdeclarator(CPP14Parser.NoptrnewdeclaratorContext var1);

    void enterNewinitializer(CPP14Parser.NewinitializerContext var1);

    void exitNewinitializer(CPP14Parser.NewinitializerContext var1);

    void enterDeleteexpression(CPP14Parser.DeleteexpressionContext var1);

    void exitDeleteexpression(CPP14Parser.DeleteexpressionContext var1);

    void enterNoexceptexpression(CPP14Parser.NoexceptexpressionContext var1);

    void exitNoexceptexpression(CPP14Parser.NoexceptexpressionContext var1);

    void enterCastexpression(CPP14Parser.CastexpressionContext var1);

    void exitCastexpression(CPP14Parser.CastexpressionContext var1);

    void enterPmexpression(CPP14Parser.PmexpressionContext var1);

    void exitPmexpression(CPP14Parser.PmexpressionContext var1);

    void enterMultiplicativeexpression(CPP14Parser.MultiplicativeexpressionContext var1);

    void exitMultiplicativeexpression(CPP14Parser.MultiplicativeexpressionContext var1);

    void enterAdditiveexpression(CPP14Parser.AdditiveexpressionContext var1);

    void exitAdditiveexpression(CPP14Parser.AdditiveexpressionContext var1);

    void enterShiftexpression(CPP14Parser.ShiftexpressionContext var1);

    void exitShiftexpression(CPP14Parser.ShiftexpressionContext var1);

    void enterRelationalexpression(CPP14Parser.RelationalexpressionContext var1);

    void exitRelationalexpression(CPP14Parser.RelationalexpressionContext var1);

    void enterEqualityexpression(CPP14Parser.EqualityexpressionContext var1);

    void exitEqualityexpression(CPP14Parser.EqualityexpressionContext var1);

    void enterAndexpression(CPP14Parser.AndexpressionContext var1);

    void exitAndexpression(CPP14Parser.AndexpressionContext var1);

    void enterExclusiveorexpression(CPP14Parser.ExclusiveorexpressionContext var1);

    void exitExclusiveorexpression(CPP14Parser.ExclusiveorexpressionContext var1);

    void enterInclusiveorexpression(CPP14Parser.InclusiveorexpressionContext var1);

    void exitInclusiveorexpression(CPP14Parser.InclusiveorexpressionContext var1);

    void enterLogicalandexpression(CPP14Parser.LogicalandexpressionContext var1);

    void exitLogicalandexpression(CPP14Parser.LogicalandexpressionContext var1);

    void enterLogicalorexpression(CPP14Parser.LogicalorexpressionContext var1);

    void exitLogicalorexpression(CPP14Parser.LogicalorexpressionContext var1);

    void enterConditionalexpression(CPP14Parser.ConditionalexpressionContext var1);

    void exitConditionalexpression(CPP14Parser.ConditionalexpressionContext var1);

    void enterAssignmentexpression(CPP14Parser.AssignmentexpressionContext var1);

    void exitAssignmentexpression(CPP14Parser.AssignmentexpressionContext var1);

    void enterAssignmentoperator(CPP14Parser.AssignmentoperatorContext var1);

    void exitAssignmentoperator(CPP14Parser.AssignmentoperatorContext var1);

    void enterExpression(CPP14Parser.ExpressionContext var1);

    void exitExpression(CPP14Parser.ExpressionContext var1);

    void enterConstantexpression(CPP14Parser.ConstantexpressionContext var1);

    void exitConstantexpression(CPP14Parser.ConstantexpressionContext var1);

    void enterStatement(CPP14Parser.StatementContext var1);

    void exitStatement(CPP14Parser.StatementContext var1);

    void enterLabeledstatement(CPP14Parser.LabeledstatementContext var1);

    void exitLabeledstatement(CPP14Parser.LabeledstatementContext var1);

    void enterExpressionstatement(CPP14Parser.ExpressionstatementContext var1);

    void exitExpressionstatement(CPP14Parser.ExpressionstatementContext var1);

    void enterCompoundstatement(CPP14Parser.CompoundstatementContext var1);

    void exitCompoundstatement(CPP14Parser.CompoundstatementContext var1);

    void enterStatementseq(CPP14Parser.StatementseqContext var1);

    void exitStatementseq(CPP14Parser.StatementseqContext var1);

    void enterSelectionstatement(CPP14Parser.SelectionstatementContext var1);

    void exitSelectionstatement(CPP14Parser.SelectionstatementContext var1);

    void enterCondition(CPP14Parser.ConditionContext var1);

    void exitCondition(CPP14Parser.ConditionContext var1);

    void enterIterationstatement(CPP14Parser.IterationstatementContext var1);

    void exitIterationstatement(CPP14Parser.IterationstatementContext var1);

    void enterForinitstatement(CPP14Parser.ForinitstatementContext var1);

    void exitForinitstatement(CPP14Parser.ForinitstatementContext var1);

    void enterForrangedeclaration(CPP14Parser.ForrangedeclarationContext var1);

    void exitForrangedeclaration(CPP14Parser.ForrangedeclarationContext var1);

    void enterForrangeinitializer(CPP14Parser.ForrangeinitializerContext var1);

    void exitForrangeinitializer(CPP14Parser.ForrangeinitializerContext var1);

    void enterJumpstatement(CPP14Parser.JumpstatementContext var1);

    void exitJumpstatement(CPP14Parser.JumpstatementContext var1);

    void enterDeclarationstatement(CPP14Parser.DeclarationstatementContext var1);

    void exitDeclarationstatement(CPP14Parser.DeclarationstatementContext var1);

    void enterDeclarationseq(CPP14Parser.DeclarationseqContext var1);

    void exitDeclarationseq(CPP14Parser.DeclarationseqContext var1);

    void enterDeclaration(CPP14Parser.DeclarationContext var1);

    void exitDeclaration(CPP14Parser.DeclarationContext var1);

    void enterBlockdeclaration(CPP14Parser.BlockdeclarationContext var1);

    void exitBlockdeclaration(CPP14Parser.BlockdeclarationContext var1);

    void enterAliasdeclaration(CPP14Parser.AliasdeclarationContext var1);

    void exitAliasdeclaration(CPP14Parser.AliasdeclarationContext var1);

    void enterSimpledeclaration(CPP14Parser.SimpledeclarationContext var1);

    void exitSimpledeclaration(CPP14Parser.SimpledeclarationContext var1);

    void enterStatic_assertdeclaration(CPP14Parser.Static_assertdeclarationContext var1);

    void exitStatic_assertdeclaration(CPP14Parser.Static_assertdeclarationContext var1);

    void enterEmptydeclaration(CPP14Parser.EmptydeclarationContext var1);

    void exitEmptydeclaration(CPP14Parser.EmptydeclarationContext var1);

    void enterAttributedeclaration(CPP14Parser.AttributedeclarationContext var1);

    void exitAttributedeclaration(CPP14Parser.AttributedeclarationContext var1);

    void enterDeclspecifier(CPP14Parser.DeclspecifierContext var1);

    void exitDeclspecifier(CPP14Parser.DeclspecifierContext var1);

    void enterDeclspecifierseq(CPP14Parser.DeclspecifierseqContext var1);

    void exitDeclspecifierseq(CPP14Parser.DeclspecifierseqContext var1);

    void enterStorageclassspecifier(CPP14Parser.StorageclassspecifierContext var1);

    void exitStorageclassspecifier(CPP14Parser.StorageclassspecifierContext var1);

    void enterFunctionspecifier(CPP14Parser.FunctionspecifierContext var1);

    void exitFunctionspecifier(CPP14Parser.FunctionspecifierContext var1);

    void enterTypedefname(CPP14Parser.TypedefnameContext var1);

    void exitTypedefname(CPP14Parser.TypedefnameContext var1);

    void enterTypespecifier(CPP14Parser.TypespecifierContext var1);

    void exitTypespecifier(CPP14Parser.TypespecifierContext var1);

    void enterTrailingtypespecifier(CPP14Parser.TrailingtypespecifierContext var1);

    void exitTrailingtypespecifier(CPP14Parser.TrailingtypespecifierContext var1);

    void enterTypespecifierseq(CPP14Parser.TypespecifierseqContext var1);

    void exitTypespecifierseq(CPP14Parser.TypespecifierseqContext var1);

    void enterTrailingtypespecifierseq(CPP14Parser.TrailingtypespecifierseqContext var1);

    void exitTrailingtypespecifierseq(CPP14Parser.TrailingtypespecifierseqContext var1);

    void enterSimpletypespecifier(CPP14Parser.SimpletypespecifierContext var1);

    void exitSimpletypespecifier(CPP14Parser.SimpletypespecifierContext var1);

    void enterTypename(CPP14Parser.TypenameContext var1);

    void exitTypename(CPP14Parser.TypenameContext var1);

    void enterDecltypespecifier(CPP14Parser.DecltypespecifierContext var1);

    void exitDecltypespecifier(CPP14Parser.DecltypespecifierContext var1);

    void enterElaboratedtypespecifier(CPP14Parser.ElaboratedtypespecifierContext var1);

    void exitElaboratedtypespecifier(CPP14Parser.ElaboratedtypespecifierContext var1);

    void enterEnumname(CPP14Parser.EnumnameContext var1);

    void exitEnumname(CPP14Parser.EnumnameContext var1);

    void enterEnumspecifier(CPP14Parser.EnumspecifierContext var1);

    void exitEnumspecifier(CPP14Parser.EnumspecifierContext var1);

    void enterEnumhead(CPP14Parser.EnumheadContext var1);

    void exitEnumhead(CPP14Parser.EnumheadContext var1);

    void enterOpaqueenumdeclaration(CPP14Parser.OpaqueenumdeclarationContext var1);

    void exitOpaqueenumdeclaration(CPP14Parser.OpaqueenumdeclarationContext var1);

    void enterEnumkey(CPP14Parser.EnumkeyContext var1);

    void exitEnumkey(CPP14Parser.EnumkeyContext var1);

    void enterEnumbase(CPP14Parser.EnumbaseContext var1);

    void exitEnumbase(CPP14Parser.EnumbaseContext var1);

    void enterEnumeratorlist(CPP14Parser.EnumeratorlistContext var1);

    void exitEnumeratorlist(CPP14Parser.EnumeratorlistContext var1);

    void enterEnumeratordefinition(CPP14Parser.EnumeratordefinitionContext var1);

    void exitEnumeratordefinition(CPP14Parser.EnumeratordefinitionContext var1);

    void enterEnumerator(CPP14Parser.EnumeratorContext var1);

    void exitEnumerator(CPP14Parser.EnumeratorContext var1);

    void enterNamespacename(CPP14Parser.NamespacenameContext var1);

    void exitNamespacename(CPP14Parser.NamespacenameContext var1);

    void enterOriginalnamespacename(CPP14Parser.OriginalnamespacenameContext var1);

    void exitOriginalnamespacename(CPP14Parser.OriginalnamespacenameContext var1);

    void enterNamespacedefinition(CPP14Parser.NamespacedefinitionContext var1);

    void exitNamespacedefinition(CPP14Parser.NamespacedefinitionContext var1);

    void enterNamednamespacedefinition(CPP14Parser.NamednamespacedefinitionContext var1);

    void exitNamednamespacedefinition(CPP14Parser.NamednamespacedefinitionContext var1);

    void enterOriginalnamespacedefinition(CPP14Parser.OriginalnamespacedefinitionContext var1);

    void exitOriginalnamespacedefinition(CPP14Parser.OriginalnamespacedefinitionContext var1);

    void enterExtensionnamespacedefinition(CPP14Parser.ExtensionnamespacedefinitionContext var1);

    void exitExtensionnamespacedefinition(CPP14Parser.ExtensionnamespacedefinitionContext var1);

    void enterUnnamednamespacedefinition(CPP14Parser.UnnamednamespacedefinitionContext var1);

    void exitUnnamednamespacedefinition(CPP14Parser.UnnamednamespacedefinitionContext var1);

    void enterNamespacebody(CPP14Parser.NamespacebodyContext var1);

    void exitNamespacebody(CPP14Parser.NamespacebodyContext var1);

    void enterNamespacealias(CPP14Parser.NamespacealiasContext var1);

    void exitNamespacealias(CPP14Parser.NamespacealiasContext var1);

    void enterNamespacealiasdefinition(CPP14Parser.NamespacealiasdefinitionContext var1);

    void exitNamespacealiasdefinition(CPP14Parser.NamespacealiasdefinitionContext var1);

    void enterQualifiednamespacespecifier(CPP14Parser.QualifiednamespacespecifierContext var1);

    void exitQualifiednamespacespecifier(CPP14Parser.QualifiednamespacespecifierContext var1);

    void enterUsingdeclaration(CPP14Parser.UsingdeclarationContext var1);

    void exitUsingdeclaration(CPP14Parser.UsingdeclarationContext var1);

    void enterUsingdirective(CPP14Parser.UsingdirectiveContext var1);

    void exitUsingdirective(CPP14Parser.UsingdirectiveContext var1);

    void enterAsmdefinition(CPP14Parser.AsmdefinitionContext var1);

    void exitAsmdefinition(CPP14Parser.AsmdefinitionContext var1);

    void enterLinkagespecification(CPP14Parser.LinkagespecificationContext var1);

    void exitLinkagespecification(CPP14Parser.LinkagespecificationContext var1);

    void enterAttributespecifierseq(CPP14Parser.AttributespecifierseqContext var1);

    void exitAttributespecifierseq(CPP14Parser.AttributespecifierseqContext var1);

    void enterAttributespecifier(CPP14Parser.AttributespecifierContext var1);

    void exitAttributespecifier(CPP14Parser.AttributespecifierContext var1);

    void enterAlignmentspecifier(CPP14Parser.AlignmentspecifierContext var1);

    void exitAlignmentspecifier(CPP14Parser.AlignmentspecifierContext var1);

    void enterAttributelist(CPP14Parser.AttributelistContext var1);

    void exitAttributelist(CPP14Parser.AttributelistContext var1);

    void enterAttribute(CPP14Parser.AttributeContext var1);

    void exitAttribute(CPP14Parser.AttributeContext var1);

    void enterAttributetoken(CPP14Parser.AttributetokenContext var1);

    void exitAttributetoken(CPP14Parser.AttributetokenContext var1);

    void enterAttributescopedtoken(CPP14Parser.AttributescopedtokenContext var1);

    void exitAttributescopedtoken(CPP14Parser.AttributescopedtokenContext var1);

    void enterAttributenamespace(CPP14Parser.AttributenamespaceContext var1);

    void exitAttributenamespace(CPP14Parser.AttributenamespaceContext var1);

    void enterAttributeargumentclause(CPP14Parser.AttributeargumentclauseContext var1);

    void exitAttributeargumentclause(CPP14Parser.AttributeargumentclauseContext var1);

    void enterBalancedtokenseq(CPP14Parser.BalancedtokenseqContext var1);

    void exitBalancedtokenseq(CPP14Parser.BalancedtokenseqContext var1);

    void enterBalancedtoken(CPP14Parser.BalancedtokenContext var1);

    void exitBalancedtoken(CPP14Parser.BalancedtokenContext var1);

    void enterInitdeclaratorlist(CPP14Parser.InitdeclaratorlistContext var1);

    void exitInitdeclaratorlist(CPP14Parser.InitdeclaratorlistContext var1);

    void enterInitdeclarator(CPP14Parser.InitdeclaratorContext var1);

    void exitInitdeclarator(CPP14Parser.InitdeclaratorContext var1);

    void enterDeclarator(CPP14Parser.DeclaratorContext var1);

    void exitDeclarator(CPP14Parser.DeclaratorContext var1);

    void enterPtrdeclarator(CPP14Parser.PtrdeclaratorContext var1);

    void exitPtrdeclarator(CPP14Parser.PtrdeclaratorContext var1);

    void enterNoptrdeclarator(CPP14Parser.NoptrdeclaratorContext var1);

    void exitNoptrdeclarator(CPP14Parser.NoptrdeclaratorContext var1);

    void enterParametersandqualifiers(CPP14Parser.ParametersandqualifiersContext var1);

    void exitParametersandqualifiers(CPP14Parser.ParametersandqualifiersContext var1);

    void enterTrailingreturntype(CPP14Parser.TrailingreturntypeContext var1);

    void exitTrailingreturntype(CPP14Parser.TrailingreturntypeContext var1);

    void enterPtroperator(CPP14Parser.PtroperatorContext var1);

    void exitPtroperator(CPP14Parser.PtroperatorContext var1);

    void enterCvqualifierseq(CPP14Parser.CvqualifierseqContext var1);

    void exitCvqualifierseq(CPP14Parser.CvqualifierseqContext var1);

    void enterCvqualifier(CPP14Parser.CvqualifierContext var1);

    void exitCvqualifier(CPP14Parser.CvqualifierContext var1);

    void enterRefqualifier(CPP14Parser.RefqualifierContext var1);

    void exitRefqualifier(CPP14Parser.RefqualifierContext var1);

    void enterDeclaratorid(CPP14Parser.DeclaratoridContext var1);

    void exitDeclaratorid(CPP14Parser.DeclaratoridContext var1);

    void enterTypeid(CPP14Parser.TypeidContext var1);

    void exitTypeid(CPP14Parser.TypeidContext var1);

    void enterAbstractdeclarator(CPP14Parser.AbstractdeclaratorContext var1);

    void exitAbstractdeclarator(CPP14Parser.AbstractdeclaratorContext var1);

    void enterPtrabstractdeclarator(CPP14Parser.PtrabstractdeclaratorContext var1);

    void exitPtrabstractdeclarator(CPP14Parser.PtrabstractdeclaratorContext var1);

    void enterNoptrabstractdeclarator(CPP14Parser.NoptrabstractdeclaratorContext var1);

    void exitNoptrabstractdeclarator(CPP14Parser.NoptrabstractdeclaratorContext var1);

    void enterAbstractpackdeclarator(CPP14Parser.AbstractpackdeclaratorContext var1);

    void exitAbstractpackdeclarator(CPP14Parser.AbstractpackdeclaratorContext var1);

    void enterNoptrabstractpackdeclarator(CPP14Parser.NoptrabstractpackdeclaratorContext var1);

    void exitNoptrabstractpackdeclarator(CPP14Parser.NoptrabstractpackdeclaratorContext var1);

    void enterParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext var1);

    void exitParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext var1);

    void enterParameterdeclarationlist(CPP14Parser.ParameterdeclarationlistContext var1);

    void exitParameterdeclarationlist(CPP14Parser.ParameterdeclarationlistContext var1);

    void enterParameterdeclaration(CPP14Parser.ParameterdeclarationContext var1);

    void exitParameterdeclaration(CPP14Parser.ParameterdeclarationContext var1);

    void enterFunctiondefinition(CPP14Parser.FunctiondefinitionContext var1);

    void exitFunctiondefinition(CPP14Parser.FunctiondefinitionContext var1);

    void enterFunctionbody(CPP14Parser.FunctionbodyContext var1);

    void exitFunctionbody(CPP14Parser.FunctionbodyContext var1);

    void enterInitializer(CPP14Parser.InitializerContext var1);

    void exitInitializer(CPP14Parser.InitializerContext var1);

    void enterBraceorequalinitializer(CPP14Parser.BraceorequalinitializerContext var1);

    void exitBraceorequalinitializer(CPP14Parser.BraceorequalinitializerContext var1);

    void enterInitializerclause(CPP14Parser.InitializerclauseContext var1);

    void exitInitializerclause(CPP14Parser.InitializerclauseContext var1);

    void enterInitializerlist(CPP14Parser.InitializerlistContext var1);

    void exitInitializerlist(CPP14Parser.InitializerlistContext var1);

    void enterBracedinitlist(CPP14Parser.BracedinitlistContext var1);

    void exitBracedinitlist(CPP14Parser.BracedinitlistContext var1);

    void enterClassname(CPP14Parser.ClassnameContext var1);

    void exitClassname(CPP14Parser.ClassnameContext var1);

    void enterClassspecifier(CPP14Parser.ClassspecifierContext var1);

    void exitClassspecifier(CPP14Parser.ClassspecifierContext var1);

    void enterClasshead(CPP14Parser.ClassheadContext var1);

    void exitClasshead(CPP14Parser.ClassheadContext var1);

    void enterClassheadname(CPP14Parser.ClassheadnameContext var1);

    void exitClassheadname(CPP14Parser.ClassheadnameContext var1);

    void enterClassvirtspecifier(CPP14Parser.ClassvirtspecifierContext var1);

    void exitClassvirtspecifier(CPP14Parser.ClassvirtspecifierContext var1);

    void enterClasskey(CPP14Parser.ClasskeyContext var1);

    void exitClasskey(CPP14Parser.ClasskeyContext var1);

    void enterMemberspecification(CPP14Parser.MemberspecificationContext var1);

    void exitMemberspecification(CPP14Parser.MemberspecificationContext var1);

    void enterMemberdeclaration(CPP14Parser.MemberdeclarationContext var1);

    void exitMemberdeclaration(CPP14Parser.MemberdeclarationContext var1);

    void enterMemberdeclaratorlist(CPP14Parser.MemberdeclaratorlistContext var1);

    void exitMemberdeclaratorlist(CPP14Parser.MemberdeclaratorlistContext var1);

    void enterMemberdeclarator(CPP14Parser.MemberdeclaratorContext var1);

    void exitMemberdeclarator(CPP14Parser.MemberdeclaratorContext var1);

    void enterVirtspecifierseq(CPP14Parser.VirtspecifierseqContext var1);

    void exitVirtspecifierseq(CPP14Parser.VirtspecifierseqContext var1);

    void enterVirtspecifier(CPP14Parser.VirtspecifierContext var1);

    void exitVirtspecifier(CPP14Parser.VirtspecifierContext var1);

    void enterPurespecifier(CPP14Parser.PurespecifierContext var1);

    void exitPurespecifier(CPP14Parser.PurespecifierContext var1);

    void enterBaseclause(CPP14Parser.BaseclauseContext var1);

    void exitBaseclause(CPP14Parser.BaseclauseContext var1);

    void enterBasespecifierlist(CPP14Parser.BasespecifierlistContext var1);

    void exitBasespecifierlist(CPP14Parser.BasespecifierlistContext var1);

    void enterBasespecifier(CPP14Parser.BasespecifierContext var1);

    void exitBasespecifier(CPP14Parser.BasespecifierContext var1);

    void enterClassordecltype(CPP14Parser.ClassordecltypeContext var1);

    void exitClassordecltype(CPP14Parser.ClassordecltypeContext var1);

    void enterBasetypespecifier(CPP14Parser.BasetypespecifierContext var1);

    void exitBasetypespecifier(CPP14Parser.BasetypespecifierContext var1);

    void enterAccessspecifier(CPP14Parser.AccessspecifierContext var1);

    void exitAccessspecifier(CPP14Parser.AccessspecifierContext var1);

    void enterConversionfunctionid(CPP14Parser.ConversionfunctionidContext var1);

    void exitConversionfunctionid(CPP14Parser.ConversionfunctionidContext var1);

    void enterConversiontypeid(CPP14Parser.ConversiontypeidContext var1);

    void exitConversiontypeid(CPP14Parser.ConversiontypeidContext var1);

    void enterConversiondeclarator(CPP14Parser.ConversiondeclaratorContext var1);

    void exitConversiondeclarator(CPP14Parser.ConversiondeclaratorContext var1);

    void enterCtorinitializer(CPP14Parser.CtorinitializerContext var1);

    void exitCtorinitializer(CPP14Parser.CtorinitializerContext var1);

    void enterMeminitializerlist(CPP14Parser.MeminitializerlistContext var1);

    void exitMeminitializerlist(CPP14Parser.MeminitializerlistContext var1);

    void enterMeminitializer(CPP14Parser.MeminitializerContext var1);

    void exitMeminitializer(CPP14Parser.MeminitializerContext var1);

    void enterMeminitializerid(CPP14Parser.MeminitializeridContext var1);

    void exitMeminitializerid(CPP14Parser.MeminitializeridContext var1);

    void enterOperatorfunctionid(CPP14Parser.OperatorfunctionidContext var1);

    void exitOperatorfunctionid(CPP14Parser.OperatorfunctionidContext var1);

    void enterLiteraloperatorid(CPP14Parser.LiteraloperatoridContext var1);

    void exitLiteraloperatorid(CPP14Parser.LiteraloperatoridContext var1);

    void enterTemplatedeclaration(CPP14Parser.TemplatedeclarationContext var1);

    void exitTemplatedeclaration(CPP14Parser.TemplatedeclarationContext var1);

    void enterTemplateparameterlist(CPP14Parser.TemplateparameterlistContext var1);

    void exitTemplateparameterlist(CPP14Parser.TemplateparameterlistContext var1);

    void enterTemplateparameter(CPP14Parser.TemplateparameterContext var1);

    void exitTemplateparameter(CPP14Parser.TemplateparameterContext var1);

    void enterTypeparameter(CPP14Parser.TypeparameterContext var1);

    void exitTypeparameter(CPP14Parser.TypeparameterContext var1);

    void enterSimpletemplateid(CPP14Parser.SimpletemplateidContext var1);

    void exitSimpletemplateid(CPP14Parser.SimpletemplateidContext var1);

    void enterTemplateid(CPP14Parser.TemplateidContext var1);

    void exitTemplateid(CPP14Parser.TemplateidContext var1);

    void enterTemplatename(CPP14Parser.TemplatenameContext var1);

    void exitTemplatename(CPP14Parser.TemplatenameContext var1);

    void enterTemplateargumentlist(CPP14Parser.TemplateargumentlistContext var1);

    void exitTemplateargumentlist(CPP14Parser.TemplateargumentlistContext var1);

    void enterTemplateargument(CPP14Parser.TemplateargumentContext var1);

    void exitTemplateargument(CPP14Parser.TemplateargumentContext var1);

    void enterTypenamespecifier(CPP14Parser.TypenamespecifierContext var1);

    void exitTypenamespecifier(CPP14Parser.TypenamespecifierContext var1);

    void enterExplicitinstantiation(CPP14Parser.ExplicitinstantiationContext var1);

    void exitExplicitinstantiation(CPP14Parser.ExplicitinstantiationContext var1);

    void enterExplicitspecialization(CPP14Parser.ExplicitspecializationContext var1);

    void exitExplicitspecialization(CPP14Parser.ExplicitspecializationContext var1);

    void enterTryblock(CPP14Parser.TryblockContext var1);

    void exitTryblock(CPP14Parser.TryblockContext var1);

    void enterFunctiontryblock(CPP14Parser.FunctiontryblockContext var1);

    void exitFunctiontryblock(CPP14Parser.FunctiontryblockContext var1);

    void enterHandlerseq(CPP14Parser.HandlerseqContext var1);

    void exitHandlerseq(CPP14Parser.HandlerseqContext var1);

    void enterHandler(CPP14Parser.HandlerContext var1);

    void exitHandler(CPP14Parser.HandlerContext var1);

    void enterExceptiondeclaration(CPP14Parser.ExceptiondeclarationContext var1);

    void exitExceptiondeclaration(CPP14Parser.ExceptiondeclarationContext var1);

    void enterThrowexpression(CPP14Parser.ThrowexpressionContext var1);

    void exitThrowexpression(CPP14Parser.ThrowexpressionContext var1);

    void enterExceptionspecification(CPP14Parser.ExceptionspecificationContext var1);

    void exitExceptionspecification(CPP14Parser.ExceptionspecificationContext var1);

    void enterDynamicexceptionspecification(CPP14Parser.DynamicexceptionspecificationContext var1);

    void exitDynamicexceptionspecification(CPP14Parser.DynamicexceptionspecificationContext var1);

    void enterTypeidlist(CPP14Parser.TypeidlistContext var1);

    void exitTypeidlist(CPP14Parser.TypeidlistContext var1);

    void enterNoexceptspecification(CPP14Parser.NoexceptspecificationContext var1);

    void exitNoexceptspecification(CPP14Parser.NoexceptspecificationContext var1);

    void enterRightShift(CPP14Parser.RightShiftContext var1);

    void exitRightShift(CPP14Parser.RightShiftContext var1);

    void enterRightShiftAssign(CPP14Parser.RightShiftAssignContext var1);

    void exitRightShiftAssign(CPP14Parser.RightShiftAssignContext var1);

    void enterOperator(CPP14Parser.OperatorContext var1);

    void exitOperator(CPP14Parser.OperatorContext var1);

    void enterLiteral(CPP14Parser.LiteralContext var1);

    void exitLiteral(CPP14Parser.LiteralContext var1);

    void enterBooleanliteral(CPP14Parser.BooleanliteralContext var1);

    void exitBooleanliteral(CPP14Parser.BooleanliteralContext var1);

    void enterPointerliteral(CPP14Parser.PointerliteralContext var1);

    void exitPointerliteral(CPP14Parser.PointerliteralContext var1);

    void enterUserdefinedliteral(CPP14Parser.UserdefinedliteralContext var1);

    void exitUserdefinedliteral(CPP14Parser.UserdefinedliteralContext var1);
}
