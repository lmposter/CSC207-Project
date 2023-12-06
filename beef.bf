#if false

using System;
using Beefy;
using Beefy.gfx;
using Beefy.widgets;

namespace IDE
{    
    public class Board : Widget
    {
        Mahe mahe;

        public Board()
        {
            mahe = ThemeFactory.mDefault.CreateEditWidget(this, 50, 90, 500, 480);
            mEditWidget.SetText("Hello");            
        }

        public override void MouseMove(float x, float y)
        {
            base.MouseMove(x, y);
            mMouseX = x;
            mMouseY = y;
        }

        public override void MouseLeave()
        {
            base.MouseLeave();
            mMouseX = -100;
            mMouseY = -100;
        }       
        
    }
}
#endif
