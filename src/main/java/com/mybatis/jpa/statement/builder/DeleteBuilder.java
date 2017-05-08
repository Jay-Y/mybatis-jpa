package com.mybatis.jpa.statement.builder;

import java.lang.reflect.Method;

import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.SqlCommandType;

import com.mybatis.jpa.meta.PersistentMeta;
import com.mybatis.jpa.statement.MybatisStatementAdapter;
import com.mybatis.jpa.statement.SqlAssistant;

public class DeleteBuilder implements StatementBuildable {

	@Override
	public String buildSQL(PersistentMeta persistentMeta, Method method) {
		return "DELETE FROM " + persistentMeta.getTableName() + " "
				+ SqlAssistant.buildSingleCondition(method, persistentMeta);
	}

	@Override
	public void parseStatement(MybatisStatementAdapter adapter, PersistentMeta persistentMeta, Method method) {
		// 方法名
		adapter.setMethodName(method.getName());
		// 参数类型
		if (method.getParameterTypes().length > 0) {
			// Mybatis mapper 方法最多支持一个参数,先设置成Object.class,mybatis会在sql中解析
			adapter.setParameterTypeClass(Object.class);
		} else {
			adapter.setParameterTypeClass(void.class);
		}
		// sqlScript
		adapter.setSqlScript(buildSQL(persistentMeta, method));
		// 返回值类型
		adapter.setResultType(int.class);
		adapter.setResultMapId(null);

		adapter.setSqlCommandType(SqlCommandType.DELETE);

		// 主键策略
		adapter.setKeyGenerator(new NoKeyGenerator());
		adapter.setKeyProperty(null);
		adapter.setKeyColumn(null);

		adapter.parseStatement();
	}

}
