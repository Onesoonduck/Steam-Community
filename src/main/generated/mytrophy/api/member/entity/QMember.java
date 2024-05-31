package mytrophy.api.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1624027913L;

    public static final QMember member = new QMember("member1");

    public final ListPath<mytrophy.api.article.entity.Article, mytrophy.api.article.entity.QArticle> articles = this.<mytrophy.api.article.entity.Article, mytrophy.api.article.entity.QArticle>createList("articles", mytrophy.api.article.entity.Article.class, mytrophy.api.article.entity.QArticle.class, PathInits.DIRECT2);

    public final ListPath<mytrophy.api.game.entity.Category, mytrophy.api.game.entity.QCategory> categories = this.<mytrophy.api.game.entity.Category, mytrophy.api.game.entity.QCategory>createList("categories", mytrophy.api.game.entity.Category.class, mytrophy.api.game.entity.QCategory.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> created_at = createDateTime("created_at", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imagePath = createString("imagePath");

    public final StringPath loginType = createString("loginType");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath role = createString("role");

    public final NumberPath<Long> steamId = createNumber("steamId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> update_at = createDateTime("update_at", java.time.LocalDateTime.class);

    public final StringPath username = createString("username");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

