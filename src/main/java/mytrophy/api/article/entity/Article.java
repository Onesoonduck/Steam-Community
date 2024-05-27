package mytrophy.api.article.entity;

import jakarta.persistence.*;
import lombok.*;
import mytrophy.api.article.dto.ArticleRequest;
import mytrophy.api.article.enumentity.Header;
import mytrophy.api.comment.entity.Comment;
import mytrophy.api.common.base.BaseEntity;
import mytrophy.api.member.entity.Member;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 protected로 설정
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성되는 값으로 설정
    private Long id;

    @Enumerated(EnumType.STRING)
    private Header header;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    private int cntUp; // 좋아요 수

    private String imagePath; // 이미지 경로


    //TODO : member 연관관계 관련 로직 추가해야 함
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 설정
    @JoinColumn(name = "member_id")
    private Member member; // 회원

    //TODO : comment 연관관계 관련 로직 추가해야 함
//    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
//    private List<Comment> comments; // 댓글

    @Builder // 빌더 패턴 적용
    public Article(Header header, String name, String content, int cntUp, String imagePath, Member member) {
        this.header = header;
        this.name = name;
        this.content = content;
        this.cntUp = cntUp;
        this.imagePath = imagePath;
        this.member = member;
    }

    // 게시글 생성 로직
    public static Article createArticle(ArticleRequest articleRequest) {
        return Article.builder()
            .header(articleRequest.getHeader())
            .name(articleRequest.getName())
            .content(articleRequest.getContent())
            .cntUp(0)
            .imagePath(articleRequest.getImagePath())
            .member(articleRequest.getMember())
            .build();
    }

    // 게시글 수정
    public void updateArticle(Header header, String name, String content, String imagePath) {
        this.header = header;
        this.name = name;
        this.content = content;
        this.imagePath = imagePath;
    }

    // 좋아요 증가
    public void upCntUp() {
        this.cntUp++;
    }

    // 좋아요 감소
    public void CntUpDown() {
        this.cntUp--;
    }

}
