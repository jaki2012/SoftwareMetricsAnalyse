//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package GithubParserUtils;

import com.github.javaparser.PositionUtils;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.CommentsCollection;
import com.github.javaparser.ast.comments.CommentsParser;
import com.github.javaparser.ast.comments.LineComment;
import java.io.IOException;
import java.util.*;

class CommentsInserter {

    private boolean doNotAssignCommentsPreceedingEmptyLines = true;
    private boolean doNotConsiderAnnotationsAsNodeStartForCodeAttribution = false;

    private ArrayList<String> commentTracked = new ArrayList<String>();
    public int LOC_CODE_AND_COMMENT = 0;
    public ArrayList<Comment> commentNode = new ArrayList<Comment>();

    CommentsInserter() {
    }

    public void insertComments(CompilationUnit cu, String cuSourceCode) throws IOException {
        CommentsParser commentsParser = new CommentsParser();
        CommentsCollection allComments = commentsParser.parse(cuSourceCode);
        this.insertCommentsInCu(cu, allComments);
    }

    public boolean getDoNotConsiderAnnotationsAsNodeStartForCodeAttribution() {
        return this.doNotConsiderAnnotationsAsNodeStartForCodeAttribution;
    }

    public void setDoNotConsiderAnnotationsAsNodeStartForCodeAttribution(boolean newValue) {
        this.doNotConsiderAnnotationsAsNodeStartForCodeAttribution = newValue;
    }

    public boolean getDoNotAssignCommentsPreceedingEmptyLines() {
        return this.doNotAssignCommentsPreceedingEmptyLines;
    }

    public void setDoNotAssignCommentsPreceedingEmptyLines(boolean newValue) {
        this.doNotAssignCommentsPreceedingEmptyLines = newValue;
    }

    private void insertCommentsInCu(CompilationUnit cu, CommentsCollection commentsCollection) {
        if(commentsCollection.size() != 0) {
            List comments = commentsCollection.getAll();
            PositionUtils.sortByBeginPosition(comments);
            List children = cu.getChildrenNodes();
            PositionUtils.sortByBeginPosition(children);
            if(cu.getPackage() != null && (children.isEmpty() || PositionUtils.areInOrder((Node)comments.get(0), (Node)children.get(0)))) {
                cu.setComment((Comment)comments.get(0));
                comments.remove(0);
            }

            this.insertCommentsInNode(cu, comments);
        }
    }

    private void insertCommentsInNode(Node node, List<Comment> commentsToAttribute) {
        if(!commentsToAttribute.isEmpty()) {
            List children = node.getChildrenNodes();
            PositionUtils.sortByBeginPosition(children);
            Iterator attributedComments = children.iterator();

            LinkedList childrenAndComments;
            Iterator var7;
            Comment c;
            while(attributedComments.hasNext()) {
                Node previousComment = (Node)attributedComments.next();
                childrenAndComments = new LinkedList();
                var7 = commentsToAttribute.iterator();

                while(var7.hasNext()) {
                    c = (Comment)var7.next();

                    // Added to track nums of LOC_CODE_AND_COMMENTS ,by Jiechu Li on 2016/10/16;
                    if(c.getClass().equals(LineComment.class)){
                        int commentBeginLine = c.getRange().begin.line;
                        StringBuilder commentTrackTag = new StringBuilder("");
                        commentTrackTag.append("line"+commentBeginLine)
                                .append(c.toString());
                        if(!this.commentTracked.contains(commentTrackTag.toString())){
                            if(previousComment.getRange().begin.line == commentBeginLine){
                                LOC_CODE_AND_COMMENT +=  1;
                                commentTracked.add(commentTrackTag.toString());
                                commentNode.add(c);
                            }
                        }
                    }else {
                        int commentBeginLine = c.getRange().begin.line;
                        int commentEndLine = c.getRange().end.line;
                        StringBuilder commentTrackTagBegin = new StringBuilder("");
                        commentTrackTagBegin.append("line"+commentBeginLine)
                                .append(c.toString());
                        StringBuilder commentTrackTagEnd = new StringBuilder("");
                        commentTrackTagEnd.append("line"+commentEndLine)
                                .append(c.toString());
                        if(!this.commentTracked.contains(commentTrackTagBegin.toString())){
                            if(previousComment.getRange().begin.line == commentBeginLine){
                                LOC_CODE_AND_COMMENT +=  1;
                                commentTracked.add(commentTrackTagBegin.toString());
                                commentNode.add(c);
                            }
                        }

                        if(!this.commentTracked.contains(commentTrackTagEnd.toString())){
                            if(previousComment.getRange().begin.line == commentEndLine){
                                LOC_CODE_AND_COMMENT +=  1;
                                commentTracked.add(commentTrackTagEnd.toString());
                                commentNode.add(c);
                            }
                        }
                    }

                    if(PositionUtils.nodeContains(previousComment, c, this.doNotConsiderAnnotationsAsNodeStartForCodeAttribution)) {
                        childrenAndComments.add(c);
                    }
                }

                commentsToAttribute.removeAll(childrenAndComments);
                this.insertCommentsInNode(previousComment, childrenAndComments);
            }

            LinkedList attributedComments1 = new LinkedList();
            Iterator previousComment1 = commentsToAttribute.iterator();

            while(true) {
                Comment childrenAndComments1;
                Node c1;
                do {
                    if(!previousComment1.hasNext()) {
                        Comment previousComment2 = null;
                        attributedComments1 = new LinkedList();
                        childrenAndComments = new LinkedList();
                        childrenAndComments.addAll(children);
                        childrenAndComments.addAll(commentsToAttribute);
                        PositionUtils.sortByBeginPosition(childrenAndComments, this.doNotConsiderAnnotationsAsNodeStartForCodeAttribution);
                        var7 = childrenAndComments.iterator();

                        while(true) {
                            while(var7.hasNext()) {
                                c1 = (Node)var7.next();
                                if(c1 instanceof Comment) {
                                    previousComment2 = (Comment)c1;
                                    if(!previousComment2.isOrphan()) {
                                        previousComment2 = null;
                                    }
                                } else if(previousComment2 != null && !c1.hasComment() && (!this.doNotAssignCommentsPreceedingEmptyLines || !this.thereAreLinesBetween(previousComment2, c1))) {
                                    c1.setComment(previousComment2);
                                    attributedComments1.add(previousComment2);
                                    previousComment2 = null;
                                }
                            }

                            commentsToAttribute.removeAll(attributedComments1);
                            var7 = commentsToAttribute.iterator();

                            while(var7.hasNext()) {
                                c = (Comment)var7.next();
                                if(c.isOrphan()) {
                                    node.addOrphanComment(c);
                                }
                            }

                            return;
                        }
                    }

                    childrenAndComments1 = (Comment)previousComment1.next();
                } while(!childrenAndComments1.isLineComment());

                var7 = children.iterator();

                while(var7.hasNext()) {
                    c1 = (Node)var7.next();
                    if(c1.getEnd().line == childrenAndComments1.getBegin().line && this.attributeLineCommentToNodeOrChild(c1, childrenAndComments1.asLineComment())) {
                        attributedComments1.add(childrenAndComments1);
                    }
                }
            }
        }
    }

    private boolean attributeLineCommentToNodeOrChild(Node node, LineComment lineComment) {
        if(node.getBegin().line == lineComment.getBegin().line && !node.hasComment()) {
            node.setComment(lineComment);
            return true;
        } else {
            LinkedList children = new LinkedList();
            children.addAll(node.getChildrenNodes());
            PositionUtils.sortByBeginPosition(children);
            Collections.reverse(children);
            Iterator var4 = children.iterator();

            Node child;
            do {
                if(!var4.hasNext()) {
                    return false;
                }

                child = (Node)var4.next();
            } while(!this.attributeLineCommentToNodeOrChild(child, lineComment));

            return true;
        }
    }

    private boolean thereAreLinesBetween(Node a, Node b) {
        if(!PositionUtils.areInOrder(a, b)) {
            return this.thereAreLinesBetween(b, a);
        } else {
            int endOfA = a.getEnd().line;
            return b.getBegin().line > endOfA + 1;
        }
    }
}
