package com.woniuxy.dal.mapper;

import com.woniuxy.dal.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniumrwang
 * @since 2023-04-26 11:40:03
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
    public List<Book> getBookByType(Integer typeId);
}
