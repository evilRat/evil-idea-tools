package io.evil.idea.tools.mybatis.log;

import com.intellij.execution.filters.ConsoleFilterProvider;
import com.intellij.execution.filters.Filter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * MyBatisLogConsoleFilterProvider
 * 
 * @author kongzheng
 */
public class MyBatisLogConsoleFilterProvider implements ConsoleFilterProvider {
    private final Key<MyBatisLogConsoleFilter> key = Key.create(MyBatisLogConsoleFilter.class.getName());

    public MyBatisLogConsoleFilterProvider() {

    }

    @Override
    public Filter @NotNull [] getDefaultFilters(@NotNull Project project) {
        MyBatisLogConsoleFilter filter = project.getUserData(key);
        if (Objects.isNull(filter)) {
            filter = new MyBatisLogConsoleFilter(project);
            project.putUserData(key, filter);
        }
        return new Filter[] { filter };
    }
}
