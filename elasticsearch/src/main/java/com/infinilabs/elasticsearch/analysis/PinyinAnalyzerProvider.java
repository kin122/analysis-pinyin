package com.infinilabs.elasticsearch.analysis;

import com.infinilabs.pinyin.analysis.PinyinAnalyzer;
import com.infinilabs.pinyin.analysis.PinyinConfig;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;


/**
 */
public class PinyinAnalyzerProvider extends AbstractIndexAnalyzerProvider<PinyinAnalyzer> {

    private final PinyinAnalyzer analyzer;
    private PinyinConfig config;

    public PinyinAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(name, settings);
        this.config=new ESPinyinConfig(settings);
        this.analyzer = new PinyinAnalyzer(config);
    }

    @Override
    public PinyinAnalyzer get() {
        return this.analyzer;
    }
}
