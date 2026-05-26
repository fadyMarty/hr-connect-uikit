package com.hrconnect.uikit.presentation.components.buttons

import android.graphics.RuntimeShader
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope
import org.intellij.lang.annotations.Language

@Language("AGSL")
private val NOISE_SHADER = """
    uniform vec2 iResolution;
    uniform float iTime;
    uniform vec4 iMouse;
     
    
    vec3 hash3( vec2 p )
    {
        vec3 q = vec3( dot(p,vec2(127.1,311.7)), 
    				   dot(p,vec2(269.5,183.3)), 
    				   dot(p,vec2(419.2,371.9)) );
    	return fract(sin(q)*43758.5453);
    }

    float voronoise( in vec2 p, float u, float v )
    {
    	float k = 1.0+63.0*pow(1.0-v,6.0);

        vec2 i = floor(p);
        vec2 f = fract(p);
        
    	vec2 a = vec2(0.0,0.0);
        for( int y=-2; y<=2; y++ )
        for( int x=-2; x<=2; x++ )
        {
            vec2  g = vec2( x, y );
    		vec3  o = hash3( i + g )*vec3(u,u,1.0);
    		vec2  d = g - f + o.xy;
    		float w = pow( 1.0-smoothstep(0.0,1.414,length(d)), k );
    		a += vec2(o.z*w,w);
        }
    	
        return a.x/a.y;
    }

    vec4 main( in vec2 fragCoord )
    {
    	vec2 uv = fragCoord / iResolution.xx;

        vec2 p = 0.5 - 0.5*cos( iTime+vec2(0.0,2.0) );
        
    	if( iMouse.w>0.001 ) p = vec2(0.0,1.0) + vec2(1.0,-1.0)*iMouse.xy/iResolution.xy;
    	
    	p = p*p*(3.0-2.0*p);
    	p = p*p*(3.0-2.0*p);
    	p = p*p*(3.0-2.0*p);
    	
    	float f = voronoise( 24.0*uv, p.x, p.y );
    	
    	return vec4( f, f, f, 1.0 );
    }
""".trimIndent()

@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
) {
    val time by produceState(0f) {
        while (true) {
            withInfiniteAnimationFrameMillis {
                value = it / 1000F
            }
        }
    }
    val containerColor by animateColorAsState(
        targetValue = if (enabled) {
            HrTheme.colorScheme.primary
        } else {
            HrTheme.colorScheme.primary.copy(alpha = 0.5f)
        }
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(containerColor)
            .clickable(
                enabled = enabled && !isLoading,
                onClick = onClick
            )
    ) {
        if (!enabled) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .alpha(0.5f)
                    .drawWithCache {
                        val shader = RuntimeShader(NOISE_SHADER)
                        val shaderBrush = ShaderBrush(shader)
                        shader.setFloatUniform("iResolution", size.width, size.height)
                        shader.setFloatUniform("iMouse", 0f, 0f, 0f, 0f)
                        onDrawBehind {
                            shader.setFloatUniform("iTime", time)
                            drawRect(shaderBrush)
                        }
                    }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    strokeCap = StrokeCap.Butt,
                    gapSize = 0.dp,
                    color = HrTheme.colorScheme.onPrimary,
                    trackColor = HrTheme.colorScheme.onPrimary.copy(alpha = 0.3f)
                )
            } else {
                Text(
                    text = label,
                    style = TextStyle(
                        fontFamily = Manrope,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Center,
                        color = HrTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    HrTheme {
        PrimaryButton(
            label = "Primary Default",
            onClick = {},
            enabled = false
        )
    }
}