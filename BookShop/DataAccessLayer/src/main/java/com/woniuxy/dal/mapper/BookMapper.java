package com.woniuxy.dal.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    IPage<Book> getBookByTypeTwo(Page<Book> page, Integer typeId);
}
