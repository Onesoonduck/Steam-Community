package mytrophy.api.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import mytrophy.api.article.entity.Article;
import mytrophy.api.article.entity.QArticle;
import mytrophy.api.comment.entity.QComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QArticle qArticle = QArticle.article;
    private final QComment qComment = QComment.comment;

    public ArticleQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    // 모든 게시글 조회
    public List<Article> findAll() {
        return jpaQueryFactory
            .selectFrom(qArticle)
            .fetch();
    }

    // 해당 게시글 조회 시 댓글 작성일자를 기준으로 내림차순 정렬
    public List<Article> findArticleWithCommentsOrderedByLatest(Long articleId) {
        return jpaQueryFactory
            .selectFrom(qArticle)
            .leftJoin(qArticle.comments, qComment).fetchJoin()
            .where(qArticle.id.eq(articleId))
            .orderBy(qComment.createdAt.desc())
            .fetch();
    }


}