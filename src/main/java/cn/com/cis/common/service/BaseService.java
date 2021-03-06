package cn.com.cis.common.service;

import cn.com.cis.common.dao.BaseMapper;
import cn.com.cis.common.entity.search.Searchable;
import org.springframework.data.domain.Persistable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 基础服务类
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseService<T extends Persistable, ID extends Serializable> {

    /**
     * 子类指定泛型对应的实体Mapper接口对象
     */
    abstract protected BaseMapper<T, ID> getEntityMapper();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    @Transactional
    public int insert(T entity) {
        return getEntityMapper().insert(entity);
    }

    /**
     * 修改数据
     *
     * @param entity
     * @return
     */
    @Transactional
    public int update(T entity) {
        return getEntityMapper().update(entity);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Transactional
    public int delete(ID id) {
        return getEntityMapper().delete(id);
    }

    @Transactional
    public int deleteByIds(ID... ids) {
        return getEntityMapper().deleteByIds(ids);
    }

    /**
     * 获取一条数据
     *
     * @param id
     * @return
     */
    public T fetch(ID id) {
        return getEntityMapper().fetch(id);
    }

    /**
     * 查询所有数据列表
     *
     * @param searchable
     * @return
     */
    public List<T> findList(Searchable searchable) {
        return getEntityMapper().findList(searchable);
    }

    /**
     * 查询ID数组
     *
     * @param ids
     * @return
     */
    public List<T> findByIds(ID[] ids) {
        return getEntityMapper().findByIds(ids);
    }
}
