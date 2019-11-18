package com.company.suggestionfieldtest.web.screens;

import com.haulmont.cuba.gui.components.SuggestionField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UiController("suggestionfieldtest_NewScreen")
@UiDescriptor("new-screen.xml")

public class NewScreen extends Screen {
    @Inject
    private SuggestionField sf;

    @Subscribe
    public void onInit(InitEvent event) {
        List<String> strings = Arrays.asList("John", "Andy", "Dora", "Martin", "Peter", "George");
        sf.setSearchExecutor((searchString, searchParams) ->
                strings.stream()
                        .filter(str -> StringUtils.containsIgnoreCase(str, searchString))
                        .collect(Collectors.toList()));
    }
    
}