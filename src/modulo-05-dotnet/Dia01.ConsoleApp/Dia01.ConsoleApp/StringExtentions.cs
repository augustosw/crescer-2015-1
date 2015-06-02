using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp
{
    internal static class StringExtentions
    {
        internal static string ToBacon(this string str, bool? upperCase = true)
        {
            if (upperCase == true) return str + " BACON!!!";
            return str + " bacon!!!"; 
        }

    }
}
