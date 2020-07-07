import React from 'react';
import Pif from './Pif';


import {
    Route,
    Link
} from 'react-router-dom'

function PIFList({pif, parent})
{
    return (
        <div>
            <Route exact path = "/pif"><div>
            <div className="center">
    {pif.map(pif => {console.log(pif);return <Pif id = {pif.id} LOC = {pif.loc} LOR = {pif.loa} LOA = {pif.loa} WAPS = {pif.waps} last_review_date = {pif.last_review_date}/> })}
                </div></div></Route>

        </div>
    )
}
export default PIFList