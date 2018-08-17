package daobase;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * <strong>Title : dao类<br>
 * </strong> <strong>Description : </strong>@类注释说明写在此处@<br>
 * <strong>Create on : 2017年02月15日<br>
 * </strong>
 * <p>
 * <strong>Copyright (C) Vbill Co.,Ltd.<br>
 * </strong>
 * <p>
 *
 * @author department:技术开发部 <br>
 * username:zh-pc <br>
 * email: <br>
 * @version <strong>zw有限公司-运营平台</strong><br>
 * <br>
 * <strong>修改历史:</strong><br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class DaoSupportImpl implements IDaoSupport {

    private SqlSessionTemplate sqlSessionTemplate;

    public DaoSupportImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * 执行单条sql语句
     *
     * @param sql
     * @throws Exception
     */
    public void exeSql(String sql) throws DAOException {
        try {
            System.out.println("执行语句：" + sql);
            sqlSessionTemplate.update("CommonMapper.dynamicSql", sql);
        } catch (Exception ex) {
            System.out.println("执行语句报错：" + sql);
            throw new DAOException(ex);
        }
    }


    /**
     * 根据指定的sqlmapper和实体对象
     * 执行单条sql语句
     *
     * @param mapperid
     * @param entity
     * @param <T>
     * @throws Exception
     */

    public <T> void exeSql(String mapperid, T entity) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + mapperid + "参数:" + JSON.toJSONString(entity));
            sqlSessionTemplate.update(mapperid, entity);
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 批量执行多条sql语句
     *
     * @param sqlList
     * @throws Exception
     */

    public void exeSql(List<String> sqlList) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + sqlList);
            for (String sql : sqlList) {
                sqlSessionTemplate.update("CommonMapper.dynamicSql", sql);
            }
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 执行查询，返回mao
     *
     * @param sql
     * @return
     * @throws Exception
     */

    public Map findForMap(String sql) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + sql);
            Map map = this.sqlSessionTemplate.selectOne("CommonMapper.selectSql", sql);
            TraceLoggerUtil.debug("获取结果集：" + map);
            return map;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 执行查询返回list
     *
     * @param sql
     * @return
     * @throws Exception
     */

    public List<Map> findForList(String sql) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + sql);
            List<Map> list = this.sqlSessionTemplate.selectList("CommonMapper.selectSql", sql);
            TraceLoggerUtil.debug("获取结果集：" + list);
            return list;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }


    /**
     * @param mapperid
     * @param entity
     * @param <T>
     * @param <K>
     * @return
     * @throws Exception
     */
    public <T, K> List<K> findForList(String mapperid, T entity) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + mapperid + "参数:" + JSON.toJSONString(entity));
            List<K> list = this.sqlSessionTemplate.selectList(mapperid, entity);
            return list;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 执行分页查询，返回list
     *
     * @param sql
     * @param pageNum  页码
     * @param pageSize 每页显示数量
     * @return
     * @throws Exception
     */

    public PageInfo<Map> findForList(String sql, int pageNum, int pageSize) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + sql + ";pageNum=" + pageNum + ";pageSize=" + pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<Map> list = this.sqlSessionTemplate.selectList("CommonMapper.selectSql", sql);
            TraceLoggerUtil.debug("获取结果集：" + list);
            PageInfo page = new PageInfo(list);
            return page;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 执行count语句
     *
     * @param sql
     * @return
     * @throws Exception
     */

    public int getCount(String sql) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + sql);
            int count = sqlSessionTemplate.selectOne("CommonMapper.countSql", sql);
            TraceLoggerUtil.debug("获取结果集：" + count);
            return count;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }

    /**
     * 获取当前数据源的数据库连接
     *
     * @return
     * @throws Exception
     */

    public Connection getConnection() throws DAOException {
        try {
            return sqlSessionTemplate.getConnection();
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }


    public <T, K> T findForObject(String mapperid, K entity) throws DAOException {
        try {
            TraceLoggerUtil.info("执行SQL:" + mapperid + ";参数：" + JSON.toJSONString(entity));
            T t = this.sqlSessionTemplate.selectOne(mapperid, entity);
            TraceLoggerUtil.debug("获取结果集：" + t);
            return t;
        } catch (Exception ex) {
            TraceLoggerUtil.error("执行sql出现异常", ex);
            throw new DAOException(ex);
        }
    }
}
