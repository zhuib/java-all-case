package mybatis_generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author anonymous
 * @since 2020-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "page_id", type = IdType.AUTO)
    private Integer pageId;

    private String pageKey;

    private String pageTitle;

    private String pageContent;

    private LocalDateTime pageCreateTime;

    private LocalDateTime pageUpdateTime;

    private Integer pageViewCount;

    private Integer pageCommentCount;

    private Integer pageStatus;


}
